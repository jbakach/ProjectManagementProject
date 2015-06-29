package demo.service;

import demo.model.*;
import demo.repository.DeveloperRepository;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by poo2 on 17/06/2015.
 */
@Service
@Transactional
public class ProjectService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    public void testProjects(){
        Project p=new Project();
        p.setDescription("Proyecto Java PUE");
        p.setEndDate(new Date(115,9,01));
        p.setStartDate(new Date());
        Manager manager=managerRepository.findBySurname("Bakach").get(0);
        p.setManager(manager);
        projectRepository.save(p);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date=new Date();

        Calendar cal=Calendar.getInstance();
        date =cal.getTime();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        addDevs(projectRepository.findByDescriptionPrueba("Proyecto Java PUE").get(0).getId(), developerRepository.findByCategory(Category.ARCHITECT).get(0).getId());
       // addDevs(projectRepository.findByStartDateBeforeOrEquals(sqlDate).get(0).getId(), developerRepository.findByCategory(Category.ARCHITECT).get(0).getId());
        //addDevs(projectRepository.findByStartDateBeforeOrEquals(sqlDate).get(0).getId(), developerRepository.findByCategory(Category.JUNIOR).get(0).getId());
    }
    public void addDevs(Long idProject, Long idDeveloper){
        Project project;
        project= projectRepository.findOne(idProject);
        Developer developer;
        developer=developerRepository.findOne(idDeveloper);
        if (project==null){
            System.out.println("No existe este proyecto");
        }
        if (developer==null){
            System.out.println("No existe este developer");
        }
        if (project!=null && developer!=null){
            project.getDevelopers().add(developer);
            projectRepository.save(project);
        }
    }
    public void addSpecialtiesToProjects() {

        Project project = projectRepository.findOne(1L);

        Speciality spring = specialityRepository.findByNameContains("Spring").get(0);
        Speciality android = specialityRepository.findByNameContains("Android").get(0);

        project.getSpecialties().add(spring);
        project.getSpecialties().add(android);

        projectRepository.save(project);
    }
}
