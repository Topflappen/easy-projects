package de.aisy.immo.controller.internet.step;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
public abstract class Step<T> {

    public static enum Result {

        SUCCESS,
        FAILURE_COULD_NOT_LOAD_PAGE,
        FAILURE_WRONG_RESPONSE,
        FAILURE_UNEXPECTED_LAYOUT
    }

    abstract Result proceed();

    public abstract T getResult();

    public abstract HtmlPage getFollowUpPage();

}
