package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Employee;
import demo.model.Speciality;
import demo.repository.DeveloperRepository;
import demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Gonzalo on 18/06/2015.
 */
@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    public void testDevelopers(){


        // Developer1
        Developer developer1 = new Developer();
        developer1.setName("Fulano");
        developer1.setSurname("Fulanito");
        developer1.setDateIncorporation(new Date());
        developer1.setSalary(1500.0);
        developer1.setCategory(Category.JUNIOR);

        // Developer2
        Developer developer2 = new Developer();
        developer2.setName("Lolencio");
        developer2.setSurname("Manganito");
        developer2.setDateIncorporation(new Date());
        developer2.setSalary(2500.0);
        developer2.setCategory(Category.SENIOR);

        // Developer2
        Developer developer3 = new Developer();
        developer3.setName("Manolo");
        developer3.setSurname("El_del_Bombo");
        developer3.setDateIncorporation(new Date());
        developer3.setSalary(3500.0);
        developer3.setCategory(Category.ARCHITECT);

        Speciality speciality = specialityRepository.findByName("Java").get(0);
        developer2.getSpecialties().add(speciality);

        // Guardar en DB
        developerRepository.save(developer1);
        developerRepository.save(developer2);
        developerRepository.save(developer3);

        // Print
        Employee architect = developerRepository.findByCategory(Category.ARCHITECT).get(0);
        System.out.println(architect);
    }
}
