package demo.repository;

import demo.model.Speciality;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpecialityRepository extends PagingAndSortingRepository<Speciality, Long> {
    List<Speciality> findByNameContains(@Param("name") String name);
}
