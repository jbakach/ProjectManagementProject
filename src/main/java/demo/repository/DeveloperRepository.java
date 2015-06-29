package demo.repository;

import demo.model.Category;
import demo.model.Developer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */
public interface DeveloperRepository extends PagingAndSortingRepository<Developer,Long> {
    public List<Developer> findBySurname(@Param("surname") String surname);
    public List<Developer> findByDateIncorporationAfter(@Param("dateIncorporation") Date dateIncorporation);
    public List<Developer> findByDateIncorporationBetween(@Param("from") Date from,@Param("to") Date to);
    public List<Developer> findByCategory(@Param("cat") Category cat);
    List<Developer> findByNameContains(@Param("name") String name);
}
