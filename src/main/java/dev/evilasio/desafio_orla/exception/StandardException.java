package dev.evilasio.desafio_orla.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardException extends RuntimeException {

    private String name;

    private HttpStatus status;

    public StandardException(String name, String message, HttpStatus status) {
        super(message);
        this.name = name;
        this.status = status;
    }
}
