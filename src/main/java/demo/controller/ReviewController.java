package demo.controller;

import demo.exception.*;
import demo.model.Developer;
import demo.model.Project;
import demo.model.Review;
import demo.model.Speciality;
import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import demo.repository.ReviewRespository;
import demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by poo2 on 06/07/2015.
 */
@RestController

public class ReviewController {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private ReviewRespository reviewRespository;
    @RequestMapping(value="/projects/{idProject}/developers/{idDeveloper}/specialities/{idSpeciality}/review",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Review save(@PathVariable Long idProject,@PathVariable Long idDeveloper,@PathVariable Long idSpeciality,@RequestBody Review review) {
        Project project = projectRepository.findOne(idProject);
        if (project==null)
            throw new ProjectException(idProject);
        Developer developer=developerRepository.findOne(idDeveloper);
        if(developer==null)
            throw new DeveloperException(idDeveloper);
        Speciality speciality=specialityRepository.findOne(idSpeciality);
        if (speciality==null)
            throw new SpecialityException(idSpeciality);
        if (!developer.getProjects().contains(project))
            throw new ReviewDeveloperProjectException(idProject,idDeveloper);
        if (!project.getSpecialties().contains(speciality))
            throw new ReviewProjectSpecialityException(idProject,idSpeciality);
        if (!developer.getSpecialties().contains(speciality))
            throw new ReviewDeveloperSpecialityException(idSpeciality,idDeveloper);
        review.setDateReview(new Date());
        review.setProject(project);
        review.setDeveloper(developer);
        review.setSpeciality(speciality);
        return reviewRespository.save(review);
    }
}
