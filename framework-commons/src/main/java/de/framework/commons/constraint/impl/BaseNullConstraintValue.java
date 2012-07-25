package de.framework.commons.constraint.impl;

import de.framework.commons.constraint.exception.ConstraintViolationException;

/**
 * User: Clemens Wichert
 * Date: 08.06.12
 * Time: 01:09
 */
abstract class BaseNullConstraintValue<T, C extends BaseNullConstraintValue> {

    private T value;

    public BaseNullConstraintValue(T value) {
        this.value = value;
    }

    /**
     * Check if this value is null.
     *
     * @throws ConstraintViolationException - if this value is null
     *
     * @return this
     */
    public C notNull() {

        if(value == null) {
            throw new ConstraintViolationException("not null constraint violation!");
        }

        return (C) this;
    }

    public T getValue() {
        return value;
    }
}
