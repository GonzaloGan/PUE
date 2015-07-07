package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Gonzalo on 17/06/2015.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Developer extends Employee {

    @Enumerated(EnumType.STRING)
    private Category category;

    @JsonIgnore
    // Many Developers to Many Projects
    @ManyToMany(mappedBy = "developers")
    private Set<Project> projects = new HashSet<>();

    @JsonIgnore
	// Many Developers to Many Specialties
    @ManyToMany
	private Set<Speciality> specialties = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "developer")
	private Set<Review> review = new HashSet<>();

    // void Constructor para Hibernate
    public Developer(){}

   // Getters & Setters
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
	
	public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Speciality> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Speciality> specialties) {
        this.specialties = specialties;
    }

    public Set<Review> getReview() {
        return review;
    }

    public void setReview(Set<Review> review) {
        this.review = review;
    }

    // toString()

    @Override
    public String toString() {

        // Heredar Employee.toString()
        String developer = super.toString();

        return developer + "Developer{" +
                "category=" + category +
                '}';
    }
}
