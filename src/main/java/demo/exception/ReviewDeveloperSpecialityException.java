package demo.exception;

/**
 * Created by poo2 on 06/07/2015.
 */
public class ReviewDeveloperSpecialityException extends RuntimeException {
    public ReviewDeveloperSpecialityException(Long idDeveloper, Long idSpeciality) {
        super("Developer id: " + idDeveloper + " y Speciality id: "+ idSpeciality + " no estan vinculados.");
    }
}
