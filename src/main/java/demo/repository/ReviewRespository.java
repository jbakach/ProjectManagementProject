package demo.repository;

import demo.model.Review;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by poo2 on 06/07/2015.
 */
public interface ReviewRespository extends PagingAndSortingRepository<Review, Long> {
    public List<Review> findByProjectIdAndSpecialityId(@Param("Id") Long ProjectId,@Param("Id") Long SpecialityId);
}
