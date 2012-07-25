package de.framework.commons.constraint.impl;

import de.framework.commons.constraint.exception.ConstraintViolationException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A value holder wrapper that ensures, that a certain holder object
 * does not contain two equal instances of the same class
 *
 * User: Clemens Wichert
 * Date: 08.06.12
 * Time: 00:49
 *
 */
public class UniqueValue<T> extends BaseNullConstraintValue<T, UniqueValue> {

    public static boolean IGNORE_NULL_HOLDER = false;

    private static Map<Object, Set<UniqueValue>> otherValues = new HashMap<Object, Set<UniqueValue>>();

    private Object holder;

    private UniqueValue(Object holder, T value) {
        super(value);
        this.holder = holder;
    }

    /**
     * Save a value instance in this wrapper. In this builder method, the check is being performed,
     * whether the specified holder already contains another uniqueValue whose value equals the given value.<br/>
     * If so a ConstraintViolationException will be raised
     *
     * @param holder - on this object the test will be performed, whether the given value has already been created in thie holder
     * @param value - the value instance
     * @throws ConstraintViolationException - if given value has already been defined in given holder
     *         IllegalArgumentException - if holder is null and UniqueValue.IGNORE_NULL_HOLDER has not been set to true
     * @return this
     */
    public static <T> UniqueValue<T> value(Object holder, T value) {

        if(holder == null ) {

            if(!IGNORE_NULL_HOLDER) {
                throw new IllegalArgumentException("holder must not be null! If you want to prevent this to raise an exception, set UniqueValue.IGNORE_NULL_HOLDER to true");
            }

            return new UniqueValue<T>(holder, value);
        }

        if(otherValues.get(holder) == null) {

            otherValues.put(holder, new HashSet<UniqueValue>());
        }

        UniqueValue<T> result = new UniqueValue<T>(holder, value);

        if(value != null) {

            for(UniqueValue uniqueValue: otherValues.get(holder)) {

                if(value.equals(uniqueValue.getValue())) {
                    throw new ConstraintViolationException("unique constraint violation on holder: " + holder.toString());
                }

            }

            otherValues.get(holder).add(result);
        }

        return result;
    }

    public Object getHolder() {
        return holder;
    }
}
