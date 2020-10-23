package com.revature.lastdayproject.exceptions;

public class InternalServerException extends RuntimeException{

    public InternalServerException(){super("An Exception occurred in the Server, we apologize for the inconvenience");}

    public InternalServerException(String message){ super(message);}
}
