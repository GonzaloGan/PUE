package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
/**
 * Created by Gonzalo on 17/06/2015.
 */
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    String description;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;


    //  Many Projects to One Manager
    @ManyToOne
    private Manager manager;

    @JsonIgnore
    // Many Projects to Many Developers
    @ManyToMany
    private Set<Developer> developers = new HashSet<>();

    @JsonIgnore
    // Many Projects to Many Specialties
    @ManyToMany
    private Set<Speciality> specialties = new HashSet<>();
	
	@OneToMany(mappedBy = "project")
	private Set<Review> reviews = new HashSet<>();

    // void Constructor para Hibernate
    public Project(){}

    // Getters & Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Manager getManager() { return manager; }

    public void setManager(Manager manager) { this.manager = manager; }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Set<Speciality> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Speciality> specialties) {
        this.specialties = specialties;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    // toString()
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", manager=" + manager +
                ", developers=" + developers +
                '}';
    }
    // Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return !(id != null ? !id.equals(project.id) : project.id != null);

    }
    // Hash code
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
