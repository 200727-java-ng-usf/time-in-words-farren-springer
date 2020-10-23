package com.revature.lastdayproject.exceptions;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException(){ super("You are not Authorized to access this");}

    public AuthorizationException(String message){ super(message);}
}
