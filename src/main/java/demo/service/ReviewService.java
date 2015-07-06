package demo.service;

import demo.model.Developer;
import demo.model.Review;
import demo.repository.DeveloperRepository;
import demo.repository.ReviewRespository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by poo2 on 06/07/2015.
 */
public class ReviewService {
    @Autowired
    private ReviewRespository reviewRespository;
    @Autowired
    private DeveloperRepository developerRepository;
    public void testReview(){
        Review r=new Review();
        r.setScore((long)8.5);
        developerRepository.findById()

    }
}
