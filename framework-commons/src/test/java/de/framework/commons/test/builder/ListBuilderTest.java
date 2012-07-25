package de.framework.commons.test.builder;

import de.framework.commons.builder.ListBuilder;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 08.06.12
 * Time: 02:05
 * To change this template use File | Settings | File Templates.
 */
public class ListBuilderTest {

    @Test
    public void testListBuilderAdd() {

        List<Object> result = new ListBuilder<Object>()
                .add(new Object())
                .build();

        Assert.assertTrue(result instanceof ArrayList);
        Assert.assertTrue(result.size() == 1);
    }

    @Test
    public void testListBuilderRemove() {

        Object testObject = new Object();

        List<Object> result = new ListBuilder<Object>()
                .add(testObject)
                .remove(testObject)
                .build();

        Assert.assertTrue(result instanceof ArrayList);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testListBuilderWithNullValue() {

        List<Object> result = new ListBuilder<Object>(null)
                .add(new Object())
                .build();

        Assert.assertNull(result);
    }

}
