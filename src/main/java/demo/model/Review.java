package demo.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by poo2 on 06/07/2015.
 */
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double score;

    @ManyToOne
    private Developer developer;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Speciality speciality;
    private Date dateReview= new Date();

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Date getDateReview() {
        return dateReview;
    }

    public void setDateReview(Date dateReview) {
        this.dateReview = dateReview;
    }

    public Review() {}

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", score=" + score +
                ", dateReview=" + dateReview +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (score != review.score) return false;
        if (id != null ? !id.equals(review.id) : review.id != null) return false;
        if (developer != null ? !developer.equals(review.developer) : review.developer != null) return false;
        if (project != null ? !project.equals(review.project) : review.project != null) return false;
        if (speciality != null ? !speciality.equals(review.speciality) : review.speciality != null) return false;
        return !(dateReview != null ? !dateReview.equals(review.dateReview) : review.dateReview != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (developer != null ? developer.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        result = 31 * result + (dateReview != null ? dateReview.hashCode() : 0);
        return result;
    }
}
