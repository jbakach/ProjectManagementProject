package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Employee;
import demo.repository.DeveloperRepository;
import demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 16/06/2015.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    public void testEmployees(){
        Employee employee=new Employee();
        employee.setDateIncorporation(new Date());
        employee.setName("Jamal");
        employee.setSalary(2000.0);
        employee.setSurname("Bakach");
        employeeRepository.save(employee);
        employee=new Employee();
        employee.setDateIncorporation(new Date());
        employee.setName("Pepe");
        employee.setSalary(2000.0);
        employee.setSurname("Lopez");
        employeeRepository.save(employee);
        employee=new Employee();
        employee.setDateIncorporation(new Date());
        employee.setName("Juan");
        employee.setSalary(2000.0);
        employee.setSurname("Gomez");
        employeeRepository.save(employee);
        employee=new Employee();
        employee.setDateIncorporation(new Date());
        employee.setName("Koke");
        employee.setSalary(2000.0);
        employee.setSurname("Botella");
        employeeRepository.save(employee);
        employee=new Employee();
        employee.setDateIncorporation(new Date());
        employee.setName("Jesus");
        employee.setSalary(2000.0);
        employee.setSurname("Bakach");
        employeeRepository.save(employee);
        Employee bakach= employeeRepository.findBySurname("Bakach").get(0);
        System.out.println(bakach.getName() + "-" + bakach.getSurname() + "-" + bakach.getDateIncorporation());

//        Calendar cal=Calendar.getInstance();
//        cal.set(2015,Calendar.APRIL,1);
//        Date fromDate=cal.getTime();
//
//        List<Employee> employees=employeeRepository.findByStartDateAfter(fromDate);
//        for (Employee e : employees){
//            System.out.println();
//
        Calendar cal=Calendar.getInstance();
        cal.set(2015, Calendar.JANUARY, 1);
        Date startDate=cal.getTime();
        cal.set(2015, Calendar.MARCH, 1);
        Date endDate=cal.getTime();
        cal.set(2015, Calendar.FEBRUARY, 1);
        Date dateIncorporation=cal.getTime();
        employee=new Employee();
        employee.setDateIncorporation(dateIncorporation);
        employee.setName("Jose");
        employee.setSalary(2000.0);
        employee.setSurname("Gomez");
        employeeRepository.save(employee);
        List<Employee> employees=employeeRepository.findByDateIncorporationBetween(startDate,endDate);
        for (Employee e : employees){
            System.out.println(e.toString());
        }
    };
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
    }
}
