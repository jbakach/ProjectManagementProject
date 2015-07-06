package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Developer extends Employee{
    @Column
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToMany(mappedBy = "developers")
    private Set<Project> projects=new HashSet();

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "developer")
    private Set <Review> reviews=new HashSet<>();
    @JsonIgnore
    @ManyToMany
    private Set<Speciality> specialties = new HashSet<>();

    public Developer(){}

    public Developer(Category category) {
        this.category = category;
    }

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

    @Override
    public String toString() {
        return super.toString()+"Developer{" +
                "category=" + category +
                '}';
    }
}
