package de.framework.commons.test.constraint;

import de.framework.commons.constraint.exception.ConstraintViolationException;
import de.framework.commons.constraint.impl.UniqueValue;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: topflappen
 * Date: 08.06.12
 * Time: 01:32
 * To change this template use File | Settings | File Templates.
 */
public class UniqueConstraintValueTest {

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullHolder1() {

        UniqueValue.value(null, new Object());
    }

    @Test
    public void testWithNullHolder2() {

        UniqueValue.IGNORE_NULL_HOLDER = true;

        UniqueValue.value(null, new Object());

        UniqueValue.IGNORE_NULL_HOLDER = false;
    }

    @Test(expected = ConstraintViolationException.class)
    public void testUniqueValue1() {

        Object testHolderObject = new Object();
        Object testValueObject = new Object();

        UniqueValue.value(testHolderObject, testValueObject);
        UniqueValue.value(testHolderObject, testValueObject);
    }

    @Test
    public void testUniqueValue2() {

        Object testValue1Object = new Object();
        Object testValue2Object = new Object();

        Object testHolderObject = new Object();

        UniqueValue.value(testHolderObject, testValue1Object);
        UniqueValue.value(testHolderObject, testValue2Object);
    }

    @Test(expected = ConstraintViolationException.class)
    public void testNotNull() {

        UniqueValue.value(new Object(), null).notNull();
    }

}
