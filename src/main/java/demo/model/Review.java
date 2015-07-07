package demo.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/** 
 * Created by Gonzalo on 01/07/2015.
 */
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Min(0)
	@Max(10)
    private Double score;

	private Date date;

    @ManyToOne
	private Project project;

    @ManyToOne
    private Developer developer;

	@ManyToOne
	private Speciality speciality;
	
	
	// void Constructor para Hibernate
	public Review(){}
	
	// Getters & Setters
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
		this.score = score;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    // toString()
	@Override
	public String toString() {
		return "Review{" +
				"score=" + score +
				"date=" + date +
				'}';
	}
	// Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        return !(id != null ? !id.equals(review.id) : review.id != null);

    }
    // Hash code
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
