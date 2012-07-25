package de.framework.commons.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * A simple Builder that allows creating and editing a List in a single line command.
 *
 * User: Clemens Wichert
 * Date: 08.06.12
 * Time: 01:45
 */
public class ListBuilder<T> implements CollectionBuilder<T, List<T>, ListBuilder<T>> {

    private List<T> result;

    /**
     * If this default constructor is used, an ArrayList will be created.
     */
    public ListBuilder() {
        this.result = new ArrayList<T>();
    }

    /**
     *
     * @param result list to be edited. If null, calling this methods
     * will have no effect and build() will also return null
     */
    public ListBuilder(List<T> result) {
        this.result = result;
    }

    public ListBuilder<T> add(T object) {

        if(result != null) {
            result.add(object);
        }

        return this;
    }

    public ListBuilder<T> add(int atIndex, T object) {

        if(result != null) {
            result.add(atIndex, object);
        }

        return this;
    }

    public ListBuilder<T> addAll(T[] elements) {

        if(result != null) {
            result.addAll(Arrays.asList(elements));
        }

        return this;
    }

    public ListBuilder<T> addAll(Collection<T> collection) {

        if(result != null) {
            result.addAll(collection);
        }

        return this;
    }

    public ListBuilder<T> addAll(int index, Collection<T> collection) {

        if(result != null) {
            result.addAll(index, collection);
        }

        return this;
    }

    public ListBuilder<T> remove(T object) {

        if(result != null) {
            result.remove(object);
        }

        return this;
    }

    public ListBuilder<T> clear() {

        if(result != null) {
            result.clear();
        }

        return this;
    }

    public ListBuilder<T> retainAll(Collection<T> collection) {

        if(result != null) {
            result.retainAll(collection);
        }

        return this;
    }

    public ListBuilder<T> remove(int index) {

        if(result != null) {
            result.remove(index);
        }

        return this;
    }

    public List<T> build() {
        return result;
    }

}
