package de.aisy.immo.controller.internet.step;

import com.gargoylesoftware.htmlunit.WebResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */
public interface ResponseValidator {

    boolean isExceptedResponse(WebResponse response);

}
