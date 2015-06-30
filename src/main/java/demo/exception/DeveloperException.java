package demo.exception;

/**
 * Created by poo2 on 30/06/2015.
 */
public class DeveloperException extends RuntimeException {
    public DeveloperException(Long id){
        super("Developer id: " +id+ " no existe.");
    }
}
