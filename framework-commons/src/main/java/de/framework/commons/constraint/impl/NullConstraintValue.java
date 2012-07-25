package de.framework.commons.constraint.impl;

/**
 * An object wrapper that can be used to ensure, that a certain object is not null
 *
 * User: Clemens Wichert
 * Date: 08.06.12
 * Time: 00:49
 *
 */
public class NullConstraintValue<T> extends BaseNullConstraintValue<T, NullConstraintValue> {

    public NullConstraintValue(T value) {
        super(value);
    }
}
