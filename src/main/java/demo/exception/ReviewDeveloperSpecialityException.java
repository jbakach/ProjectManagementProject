package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 06/07/2015.
 */
@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE)
public class ReviewDeveloperSpecialityException extends RuntimeException{
    public ReviewDeveloperSpecialityException(Long id, Long idd){
        super("Este desarrollador "+idd+" no tiene la especialidad con id: "+id);
    }
}
