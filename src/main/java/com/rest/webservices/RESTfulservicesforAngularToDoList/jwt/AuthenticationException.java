package com.rest.webservices.RESTfulservicesforAngularToDoList.jwt;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
