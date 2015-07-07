package demo.exception;

/**
 * Created by Gonzalo on 06/07/2015.
 */
public class ReviewProjectSpecialityException extends RuntimeException {
    public ReviewProjectSpecialityException(Long projId, Long speId){
        super("Project id: " + projId + " y Speciality id: "+ speId + " no estan vinculados.");
    }
}
