package com.dextra.fastfood.exception;

import java.text.MessageFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Invalid sandwich exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid sandwich.")
public class InvalidSandwichException extends Exception
{
    /**
     * Instantiates a new Invalid sandwich exception.
     *
     * @param message the message
     * @param args    the args
     */
    public InvalidSandwichException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }
}
