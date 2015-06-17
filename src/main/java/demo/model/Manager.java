package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by poo2 on 17/06/2015.
 */
@Entity
public class Manager extends Employee{
    @Column
    private Double bonusSuccess;
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
