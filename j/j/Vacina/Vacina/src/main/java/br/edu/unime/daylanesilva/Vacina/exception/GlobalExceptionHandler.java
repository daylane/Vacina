package br.edu.unime.daylanesilva.Vacina.exception;

import br.edu.unime.daylanesilva.Vacina.dto.DefaultError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@Slf4j
@RestControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VacinaNotFoundException.class)
    public ResponseEntity<DefaultError> handleVacinaNotFoundException(VacinaNotFoundException ex, WebRequest webRequest){
        DefaultError error = new DefaultError(String.valueOf(HttpStatus.NOT_FOUND.value()), ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
