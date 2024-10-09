package dev.evilasio.desafio_orla.exception.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.evilasio.desafio_orla.exception.StandardError;
import dev.evilasio.desafio_orla.exception.StandardException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(StandardException.class)
    public ResponseEntity<StandardError> handle(StandardException e, HttpServletRequest request) {
        HttpStatus status = e.getStatus();
        StandardError error = new StandardError(
                Instant.now(),
                status.value(),
                e.getName(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
