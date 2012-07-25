package de.framework.commons.constraint.exception;

/**
 * User: Clemens Wichert
 * Date: 08.06.12
 * Time: 00:57
 */
public class ConstraintViolationException extends RuntimeException {

    public ConstraintViolationException(String s) {
        super(s);
    }
}
