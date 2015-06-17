package demo.repository;

import demo.model.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */
public interface ManagerRepository extends PagingAndSortingRepository<Manager,Long> {
    public List<Manager> findBySurname(@Param("surname") String surname);
    public List<Manager> findByDateIncorporationAfter(@Param("dateIncorporation") Date dateIncorporation);
    public List<Manager> findByDateIncorporationBetween(@Param("from") Date from,@Param("to") Date to);
    public List<Manager> findByBonusSuccess(@Param("bonus") Double bonus);

}
