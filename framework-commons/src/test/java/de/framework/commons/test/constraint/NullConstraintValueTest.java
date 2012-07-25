package de.framework.commons.test.constraint;

import de.framework.commons.constraint.exception.ConstraintViolationException;
import de.framework.commons.constraint.impl.NullConstraintValue;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: topflappen
 * Date: 08.06.12
 * Time: 01:20
 * To change this template use File | Settings | File Templates.
 */

public class NullConstraintValueTest {

    @Test(expected = ConstraintViolationException.class)
    public void testNullConstraintValueWithNullObject() {

        Object testObject = null;

        new NullConstraintValue<Object>(testObject).notNull();
    }

    @Test
    public void testNullConstraintValueWithNotNullObject() {

        Object testObject = new Object();

        new NullConstraintValue<Object>(testObject).notNull();
    }


}
