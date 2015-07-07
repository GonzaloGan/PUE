package demo.service;

import demo.model.Speciality;
import demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Gonzalo on 19/06/2015.
 */
@Service
public class SpecialityService {

   @Autowired
   SpecialityRepository specialityRepository;

   public void testSpecialities(){

       Speciality speciality = new Speciality();
       speciality.setName("Java");

       specialityRepository.save(speciality);
   }
}
