package com.revature.timeinwords.exceptions;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException(){ super("Authentication Failed!");}

    public AuthenticationException(String message){super(message);}
}
