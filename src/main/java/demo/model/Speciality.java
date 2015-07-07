package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Gonzalo on 19/06/2015.
 */
@Entity
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @JsonIgnore
    // Many Specialties to Many Developers
    @ManyToMany(mappedBy = "specialties")
    private Set<Developer> developers = new HashSet<>();

    @JsonIgnore
    // Many Specialties to Many Projects
    @ManyToMany(mappedBy = "specialties")
    private Set<Project> projects = new HashSet<>();

    @OneToMany(mappedBy = "speciality")
    private Set<Review> reviews = new HashSet<>();

    // void Constructor para Hibernate
    public Speciality(){}

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developers=" + developers +
                ", projects=" + projects +
                '}';
    }
    // Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speciality speciality = (Speciality) o;

        return !(id != null ? !id.equals(speciality.id) : speciality.id != null);

    }
    // Hash code
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
