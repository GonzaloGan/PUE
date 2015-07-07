package demo;

import demo.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectManagementApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ProjectManagementApplication.class, args);

        SpecialityService specialityService = context.getBean(SpecialityService.class);
        specialityService.testSpecialities();

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.testEmployees();

        DeveloperService developerService = context.getBean(DeveloperService.class);
        developerService.testDevelopers();

        ManagerService managerService = context.getBean(ManagerService.class);
        managerService.testManagers();

        ProjectService projectService = context.getBean(ProjectService.class);
        projectService.testAddDevelopers();

    }
}
