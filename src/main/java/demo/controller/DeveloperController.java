package demo.controller;

import demo.exception.DeveloperException;
import demo.model.Developer;
import demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Gonzalo on 29/06/2015.
 */
@RestController
@RequestMapping("/developers")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    // Metodo POST
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Developer save(@RequestBody Developer developer){
        return developerRepository.save(developer);
    }

    // Metodo GET que devuelve todos
    @RequestMapping(method = RequestMethod.GET)
    public List<Developer> findAll() {
        List<Developer> developers = new ArrayList<Developer>();
        Iterator<Developer> iterator = developerRepository.findAll().iterator();
        while(iterator.hasNext()){
            developers.add(iterator.next());
        }

        return developers;
    }
    // Metodo GET que devuelve solo los dev Junior
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Developer getById(@PathVariable Long id){
        Developer developer = developerRepository.findOne(id);

        if (developer == null)
            throw new DeveloperException(id);

        return developer;
    }
/*
    @RequestMapping(method = RequestMethod.GET)
    public List<Developer> findByCategory() {
        List<Developer> developersByCategory = new ArrayList<>();
        Iterator<Developer> iterator = developerRepository.findByCategory(Category.JUNIOR).iterator();
        while(iterator.hasNext()){
            developersByCategory.add(iterator.next());
        }
        return developersByCategory;
    } */

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id){
        Developer developer = developerRepository.findOne(id);

        if (developer == null)
            throw new DeveloperException(id);

        developerRepository.delete(id);
    }
   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Developer updateById(@PathVariable Long id, @RequestBody Developer newDeveloper) {
     
        if(developerRepository.findOne(id) == null)
			throw new DeveloperException(id);

        developerRepository.save(newDeveloper);
		
		return newDeveloper;
		
    }
}
