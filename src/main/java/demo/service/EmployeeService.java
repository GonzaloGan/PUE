package demo.service;

import demo.model.Employee;
import demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Gonzalo on 16/06/2015.
 */

// Defines como servicio
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public void testEmployees(){
        // Crear calendario
        Calendar calendar = Calendar.getInstance();

        // *StartDate* 01/01/2015
        calendar.set(2015, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();

        // *EndDate* 01/05/2015
        calendar.set(2015, Calendar.MARCH, 1);
        Date endDate = calendar.getTime();

        // 01/02/2015
        calendar.set(2015, Calendar.FEBRUARY, 1);
        Date dateIncorporation = calendar.getTime();

        // 28/02/2015
        calendar.set(2015, Calendar.FEBRUARY, 28);
        Date anotherDateIncorporation = calendar.getTime();

        // Empleado1
        Employee employee1 = new Employee();
        employee1.setName("Carlos");
        employee1.setSurname("Mendez");
        employee1.setDateIncorporation(new Date());
        employee1.setSalary(1000.0);

        // Empleado2
        Employee employee2 = new Employee();
        employee2.setName("No_Carlos");
        employee2.setSurname("No_Mendez");
        employee2.setDateIncorporation(anotherDateIncorporation);
        employee2.setSalary(500.0);

        // Empleado3
        Employee employee3 = new Employee();
        employee3.setName("Jhon");
        employee3.setSurname("Mamon");
        employee3.setDateIncorporation(dateIncorporation);
        employee3.setSalary(0.5);

        // Guardar en DB
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);

        Employee mendez = employeeRepository.findBySurname("Mendez").get(0);
        Employee jhon = employeeRepository.findByDateIncorporationBetween(startDate,endDate).get(0);
        Employee no_mendez = employeeRepository.findByDateIncorporationBetween(startDate,endDate).get(0);


        // Print
        for( Employee eaux : employeeRepository.findByDateIncorporationBetween(startDate,endDate) ) {
            System.out.println(eaux);
        }
/*
        Project p = new Project();
        Developer d = new Developer();

        p.getDevelopers().add(d);

        d.getProjects()
*/    }

}
