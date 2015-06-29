package demo.repository;

import demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */
public interface ProjectRepository extends JpaRepository<Project,Long> {
    @Query("select p from Project p where p.description = ?1")
    public List<Project> findByDescriptionPrueba(String description);
    /*@Param("description")*/
    // @Query("select p from Project p where p.startdate <= ?1")
   // public List<Project> findByStartDateBeforeOrEquals(java.sql.Date dateIncorporation);
    public List<Project> findByEndDate(@Param("from") Date from,@Param("to") Date to);
}
