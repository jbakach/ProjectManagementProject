package demo.service;

import demo.model.Manager;
import demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */
@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;
    public void testManagers(){
        Manager m=new Manager();
        m.setDateIncorporation(new Date());
        m.setName("Mohamed");
        m.setSurname("Bakach");
        m.setSalary(2000.0);
        m.setBonusSucess(150.0);
        managerRepository.save(m);

        Manager m1=new Manager();
        m1.setDateIncorporation(new Date(113,04,03));
        m1.setName("Adil");
        m1.setSurname("Sadiki");
        m1.setSalary(1000.0);
        m1.setBonusSucess(100.0);
        managerRepository.save(m1);

        Manager m2=new Manager();
        m2.setDateIncorporation(new Date(115,01,02));
        m2.setName("Pepe");
        m2.setSurname("Lopez");
        m2.setSalary(400.0);
        m2.setBonusSucess(120.0);
        managerRepository.save(m2);
        //Here we're different object of Calendar type, in order to filter by date incorporation.
        Calendar cal=Calendar.getInstance();
        cal.set(2013, Calendar.JANUARY, 1);
        Date startDate=cal.getTime();
        Date endDate=new Date();

        List<Manager> managers=managerRepository.findByDateIncorporationBetween(startDate,endDate);
        for (Manager manager : managers){
            System.out.println(manager.toString());
        }
    }
}
