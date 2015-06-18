package demo.service;

import demo.model.Manager;
import demo.model.Project;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by poo2 on 17/06/2015.
 */
@Service
public class ProjectService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ProjectRepository projectRepository;
    public void testProjects(){
        Project p=new Project();
        p.setDescription("Proyecto Java PUE");
        p.setEndDate(new Date(115,9,01));
        p.setStartDate(new Date());
        Manager manager=managerRepository.findBySurname("Bakach").get(0);
        p.setManager(manager);
        projectRepository.save(p);
    }
}
