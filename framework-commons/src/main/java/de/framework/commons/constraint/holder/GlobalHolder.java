package de.framework.commons.constraint.holder;

/**
 * This can be used for the UniqueValue constraint to ensure, that a certain
 * instance only exist once in the entire application
 *
 * User: Clemens Wichert
 * Date: 08.06.12
 * Time: 02:12
 */
public class GlobalHolder {

    private static GlobalHolder instance;

    private GlobalHolder() {
    }

    public synchronized static GlobalHolder getInstance() {

        if(instance == null) {
            instance = new GlobalHolder();
        }

        return instance;
    }
}
