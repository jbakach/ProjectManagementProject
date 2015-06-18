package demo.model;

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
    private Set<Project> projects=new HashSet();
    @ManyToMany(mappedBy = "project")
    private Project project;
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

    @Override
    public String toString() {
        return super.toString()+"Developer{" +
                "category=" + category +
                '}';
    }
}
