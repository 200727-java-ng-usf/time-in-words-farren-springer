package com.revature.timeinwords.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(){ super("An invalid request was made");}

    public InvalidRequestException(String message){ super(message);}
}
