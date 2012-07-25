package de.framework.commons.lang;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 10.07.12
 * Time: 21:34
 * To change this template use File | Settings | File Templates.
 */
public class ValuePair<T, U> {

    private T firstObject;

    private U secondObject;

    public ValuePair() {
    }

    public ValuePair(T firstObject, U secondObject) {
        this.firstObject = firstObject;
        this.secondObject = secondObject;
    }

    public T getFirstObject() {
        return firstObject;
    }

    public void setFirstObject(T firstObject) {
        this.firstObject = firstObject;
    }

    public U getSecondObject() {
        return secondObject;
    }

    public void setSecondObject(U secondObject) {
        this.secondObject = secondObject;
    }
}
