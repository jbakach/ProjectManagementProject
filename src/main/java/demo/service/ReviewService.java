package demo.service;

import demo.model.Developer;
import demo.model.Project;
import demo.model.Review;
import demo.model.Speciality;
import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import demo.repository.ReviewRespository;
import demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by poo2 on 06/07/2015.
 */
@Service
@Transactional//Se ha de poner cuando da error could not initialize proxy- no Session , sirve para que se inicie una transaccion.
public class ReviewService {
    @Autowired
    private ReviewRespository reviewRespository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    public void testReview(){
        Review review=new Review();
        Developer developer=developerRepository.findOne((long)7);
        Project project = projectRepository.findOne((long)1);
        Speciality speciality=specialityRepository.findOne((long)2);
        review.setDateReview(new Date());
        review.setScore(8.5);
        review.setProject(project);
        review.setDeveloper(developer);
        review.setSpeciality(speciality);
        reviewRespository.save(review);

        Review review1=new Review();
        Developer developer1=developerRepository.findOne((long)7);
        speciality=specialityRepository.findOne((long)1);
        review1.setDateReview(new Date());
        review1.setScore(9);
        review1.setProject(project);
        review1.setDeveloper(developer1);
        review1.setSpeciality(speciality);
        reviewRespository.save(review1);

        Review review2=new Review();
        developer=developerRepository.findOne((long)7);
        project = projectRepository.findOne((long)1);
        speciality=specialityRepository.findOne((long)2);
        review2.setDateReview(new Date());
        review2.setScore(10);
        review2.setProject(project);
        review2.setDeveloper(developer);
        review2.setSpeciality(speciality);

        reviewRespository.save(review2);
    }
}
