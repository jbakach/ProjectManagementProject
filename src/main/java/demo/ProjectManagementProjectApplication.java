package demo;

import demo.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectManagementProjectApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(ProjectManagementProjectApplication.class,args);
        EmployeeService employeeService=context.getBean(EmployeeService.class);
        employeeService.testEmployees();
    }
}
