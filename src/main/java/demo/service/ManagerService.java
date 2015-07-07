package demo.service;

import demo.model.Manager;
import demo.model.Project;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
@Service
/**
 * Created by Gonzalo on 18/06/2015.
 */
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public void testManagers(){

        // Crear calendario
        Calendar calendar = Calendar.getInstance();

        // 28/02/2015
        calendar.set(2015, Calendar.FEBRUARY, 28);
        Date anotherDateStart = calendar.getTime();

        // Manager1
        Manager manager1 = new Manager();
        manager1.setName("Perry");
        manager1.setSurname("Porras");
        manager1.setDateIncorporation(new Date());
        manager1.setSalary(1500.0);
        manager1.setBonusSuccess(4000.0);

        // Manager2
        Manager manager2 = new Manager();
        manager2.setName("Juan");
        manager2.setSurname("Palomo");
        manager2.setDateIncorporation(new Date());
        manager2.setSalary(2500.0);
        manager2.setBonusSuccess(5000.0);


        // Manager3
        Manager manager3 = new Manager();
        manager3.setName("Nohj");
        manager3.setSurname("Eod");
        manager3.setDateIncorporation(new Date());
        manager3.setSalary(3500.0);
        manager3.setBonusSuccess(17000.0);


        // Guardar en DB
        managerRepository.save(manager1);
        managerRepository.save(manager2);
        managerRepository.save(manager3);

        // Proyecto
        Project project = new Project();
        project.setDescription("Proyecto PUE");
        project.setStartDate(anotherDateStart);
        project.setEndDate(new Date());
        project.setManager(manager2);
		
		//  Guardar en DB
        projectRepository.save(project);



        // Print
/*        Employee biggestBonus = managerRepository.findBybonusSuccess(double).get(0);
        System.out.println(biggestBonus);
*/
    }
}
