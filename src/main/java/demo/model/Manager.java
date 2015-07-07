package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Gonzalo on 17/06/2015.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Manager extends Employee {

    private Double bonusSuccess;

    @JsonIgnore
    // One Manager to many Projects
    @OneToMany(mappedBy = "manager")
    private Set<Project> projects = new HashSet<>();

    // void Constructor para Hibernate
    public Manager(){}

    // Getters & Setters
    public Double getBonusSuccess() {
        return bonusSuccess;
    }

    public void setBonusSuccess(Double bonusSuccess) {
        this.bonusSuccess = bonusSuccess;
    }
	
	public Set<Project> getProjects() {
		return projects;
	}
	
	public void setProjects() {
		this.projects = projects;
	}
	
    // toString()
    @Override
    public String toString() {
        // Heredar Employee.toString()
        String manager = super.toString();

        return manager + "Manager{" +
                "bonusSuccess=" + bonusSuccess +
                '}';
    }
}
