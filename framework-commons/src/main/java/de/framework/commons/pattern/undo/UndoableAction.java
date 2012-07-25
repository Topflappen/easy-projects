package de.framework.commons.pattern.undo;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 10.07.12
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public abstract class UndoableAction {



    public abstract Object doAction(Object... parameters);

    public abstract Object undoAction();

}
