package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Gonzalo on 05/07/2015.
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class ReviewDeveloperProjectException extends RuntimeException {
    public ReviewDeveloperProjectException(Long projId, Long devId){
        super("Project id: " + projId + " y Developer id: "+ devId + " no estan vinculados.");
    }
}