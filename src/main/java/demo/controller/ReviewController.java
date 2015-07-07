package demo.controller;

import demo.exception.*;
import demo.model.Developer;
import demo.model.Project;
import demo.model.Review;
import demo.model.Speciality;
import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import demo.repository.ReviewRepository;
import demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * Created by Gonzalo on 05/07/2015.	
 */
@RestController
@Transactional
public class ReviewController {

	@Autowired
    private ProjectRepository projectRepository;
	
	@Autowired
	private DeveloperRepository developerRepository;

	@Autowired
	private SpecialityRepository specialityRepository;

    @Autowired
    private ReviewRepository reviewRepository;
	

	@RequestMapping(value ="/projects/{idProject}/developers/{idDeveloper}/specialities/{idSpeciality}/review", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Review addReview(@PathVariable Long idProject, @PathVariable Long idDeveloper,@PathVariable Long idSpeciality,
	@RequestBody Review review ) {
		
		// Instanciamos un projecto a partir del id recibido 
        Project project = projectRepository.findOne(idProject);

		// Si no existe lanzamos excepcion 
        if (project == null)
            throw new ProjectException(idProject);

		// Instanciamos un developer a partir del id recibido 
        Developer developer = developerRepository.findOne(idDeveloper);
		
		// Si no existe lanzamos excepcion
        if (developer == null)
            throw new DeveloperException(idDeveloper);

        Speciality speciality = specialityRepository.findOne(idSpeciality);

        if (speciality == null)
            throw new SpecialityException(idSpeciality);
			
		/*  */
		if ( ! developer.getProjects().contains(project) )
			throw new ReviewDeveloperProjectException(idProject, idDeveloper);
		
		
		if ( ! project.getSpecialties().contains(speciality) )
		    throw  new ReviewProjectSpecialityException(idProject, idSpeciality);
		
        if ( ! developer.getSpecialties().contains(speciality) )
            throw new ReviewDeveloperSpecialityException(idDeveloper, idSpeciality);

        review.setDate(new Date());
        review.setProject(project);
        review.setDeveloper(developer);
        review.setSpeciality(speciality);

        reviewRepository.save(review);

        return review;
    }
    @RequestMapping(value ="/projects/{idProject}/developers/{idDeveloper}/specialities/{idSpeciality}/review",
            method= RequestMethod.GET)
    public Review getReview(@PathVariable Long idProject, @PathVariable Long idDeveloper,@PathVariable Long idSpeciality) {

        // Instanciamos un projecto a partir del id recibido
        Project project = projectRepository.findOne(idProject);

        // Si no existe lanzamos excepcion
        if (project == null)
            throw new ProjectException(idProject);

        // Instanciamos un developer a partir del id recibido
        Developer developer = developerRepository.findOne(idDeveloper);

        // Si no existe lanzamos excepcion
        if (developer == null)
            throw new DeveloperException(idDeveloper);

        Speciality speciality = specialityRepository.findOne(idSpeciality);

        if (speciality == null)
            throw new SpecialityException(idSpeciality);

		/*  */
        if ( ! developer.getProjects().contains(project) )
            throw new ReviewDeveloperProjectException(idProject, idDeveloper);


        if ( ! project.getSpecialties().contains(speciality) )
            throw  new ReviewProjectSpecialityException(idProject, idSpeciality);

        if ( ! developer.getSpecialties().contains(speciality) )
            throw new ReviewDeveloperSpecialityException(idDeveloper, idSpeciality);

        Review review = reviewRepository.findByProjectIdAndSpecialityId(idProject, idSpeciality).get(0);


        return review;
    }
 /*   @RequestMapping(value = "/developers/{idDeveloper}/specialities/{idSpeciality}/reviews/statistics",
    method = RequestMethod.GET)
    public void statistics(@PathVariable Long idDeveloper, @PathVariable Long idSpeciality){

    }*/
}