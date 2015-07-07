package demo.service;

import demo.model.*;
import demo.repository.DeveloperRepository;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Gonzalo on 17/06/2015.
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private ManagerRepository managerRepository;

    // Añadir un developer a un project
    public void testAddDevelopers(){

        // Crear calendario
        Calendar calendar = Calendar.getInstance();

        // 28/02/2015
        calendar.set(2015, Calendar.FEBRUARY, 28);
        Date anotherDateStart = calendar.getTime();

        // Projecto 1
        Project project1 = new Project();
        project1.setDescription("Project Test");
        project1.setStartDate(anotherDateStart);
        project1.setEndDate(new Date());

        Manager manager = managerRepository.findBySurname("Porras").get(0);
        project1.setManager(manager);

        Developer dev = developerRepository.findByCategory(Category.SENIOR).get(0);
        project1.getDevelopers().add(dev);

        Speciality speciality = specialityRepository.findByName("Java").get(0);
        project1.getSpecialties().add(speciality);


        // Guardar en DB
        projectRepository.save(project1);

    }

}
