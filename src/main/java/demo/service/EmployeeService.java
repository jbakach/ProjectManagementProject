package demo.service;

import demo.model.Employee;
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
}
