package demo.exception;

/**
 * Created by poo2 on 06/07/2015.
 */
public class SpecialityException extends RuntimeException  {
    public SpecialityException(Long id){
        super("Speciality id: " + id + " no existe.");
}
}
