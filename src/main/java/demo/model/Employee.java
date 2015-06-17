package demo.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by poo2 on 15/06/2015.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    protected Long id;
    private String name;
    private String surname;
    private Double salary;
    @Temporal(TemporalType.DATE)
    private Date dateIncorporation;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Employee(String name, String surname, Double salary, Date dateIncorporation) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;

        this.dateIncorporation = dateIncorporation;
    }
    public Employee(){};

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
