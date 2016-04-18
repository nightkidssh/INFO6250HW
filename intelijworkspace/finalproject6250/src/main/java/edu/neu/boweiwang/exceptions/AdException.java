package edu.neu.boweiwang.exceptions;

/**
 * Created by kym-1992 on 4/1/16.
 */
public class AdException extends Exception
{
    public AdException(String message)
    {
        super(message);
    }

    public AdException(String message, Throwable cause)
    {
        super(message,cause);
    }
}