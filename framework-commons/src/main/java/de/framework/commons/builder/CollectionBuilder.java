package de.framework.commons.builder;

import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 08.06.12
 * Time: 02:30
 * To change this template use File | Settings | File Templates.
 */
public interface CollectionBuilder<T, R extends Collection<T>, C extends CollectionBuilder<T, R, C>> {

    public C add(T object);

    public C addAll(Collection<T> collection);

    public C remove(T object);

    public C clear();

    public C retainAll(Collection<T> collection);

    public R build();
}
