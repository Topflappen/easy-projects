package de.framework.commons.type;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 10.06.12
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */
public interface TypeConverter<F, T> {

    public T convert(F from);
}
