package de.rauldev.springbootjenkinsawsdemo.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotProductFoundException extends ResponseStatusException {

    public NotProductFoundException(HttpStatus status, String reason) {
        super(status, reason);
    }
}
