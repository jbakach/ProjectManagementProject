package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
public class  Manager extends Employee{
    @Column
    private Double bonusSuccess;
    @OneToMany (mappedBy = "manager")
    private Set<Project> projects=new HashSet();

    public Manager() {
    }

    public Double getBonusSucess() {
        return bonusSuccess;
    }

    public void setBonusSucess(Double bonusSucess) {
        this.bonusSuccess = bonusSucess;
    }

    @Override
    public String toString() {
        return super.toString()+"Manager{" +
                "bonusSuccess=" + bonusSuccess +
                '}';
    }
}
