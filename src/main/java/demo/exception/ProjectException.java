package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 30/06/2015.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND)//Restful Services, es para devolver el error 404, que es el que marca el delete ccuando falla.
public class ProjectException extends RuntimeException {
    public ProjectException(Long id){
        super("Project id: " +id+ " no existe.");
    }
}
