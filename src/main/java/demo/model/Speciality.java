package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 25/06/2015.
 */
@Entity
@Transactional
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "specialties")
    private Set<Developer> developers = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "specialties")
    private Set<Project> projects = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "speciality")
    private Set <Review> reviews=new HashSet<>();
    public Speciality() {
    }

    public Speciality(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Speciality that = (Speciality) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
