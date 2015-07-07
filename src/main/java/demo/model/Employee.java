package demo.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gonzalo on 15/06/2015.
 */

// Eso es un POJO
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    // Indicas que es primaryKey
    @Id
    // Le dices que la genere auto
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;
    private String surname;
    private Double salary;

    // Formato YY-MM-DD
    @Temporal(TemporalType.DATE)
    private Date dateIncorporation;

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getDateIncorporation() {
        return dateIncorporation;
    }

    public void setDateIncorporation(Date dateIncorporation) {
        this.dateIncorporation = dateIncorporation;
    }
	// void Constructor para Hibernate
    public Employee(){}

    // Constructor
    public Employee(String name, String surname, Double salary, Date dateIncorporation) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.dateIncorporation = dateIncorporation;
    }

    // toString()
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", dateIncorporation=" + dateIncorporation +
                '}';
    }

    // Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!id.equals(employee.id)) return false;
        if (!name.equals(employee.name)) return false;
        if (!surname.equals(employee.surname)) return false;
        if (!salary.equals(employee.salary)) return false;
        return dateIncorporation.equals(employee.dateIncorporation);

    }


    // hashCode
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + salary.hashCode();
        result = 31 * result + dateIncorporation.hashCode();
        return result;
    }
}
