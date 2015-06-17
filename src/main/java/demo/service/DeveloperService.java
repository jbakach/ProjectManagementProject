package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */
@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;
    public void testDevelopers(){
        Developer d= new Developer(Category.ARCHITECT);
        d.setName("Jamal");
        d.setSalary(16000.0);
        d.setSurname("Bakach");
        d.setDateIncorporation(new Date());
        developerRepository.save(d);
        Developer d1= new Developer(Category.JUNIOR);
        d1.setName("Joze");
        d1.setSalary(160.0);
        d1.setSurname("Golez");
        d1.setDateIncorporation(new Date());
        developerRepository.save(d1);

        Developer d2= new Developer(Category.SENIOR);
        d2.setName("Ñuñuz");
        d2.setSalary(200.0);
        d2.setSurname("Bermuz");
        d2.setDateIncorporation(new Date());
        developerRepository.save(d2);
        List<Developer> dev=developerRepository.findByCategory(Category.ARCHITECT);
        for (Developer dep : dev){
            System.out.println(dep.toString());
        }
        //changed author commit
    }
}
