package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 06/07/2015.
 */
@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE)
public class ReviewProjectSpecialityException extends RuntimeException{
    public ReviewProjectSpecialityException(Long id, Long idd){
        super("Esta especialidad "+idd+" no forma parte del proyecto con id: "+id);
    }
}
