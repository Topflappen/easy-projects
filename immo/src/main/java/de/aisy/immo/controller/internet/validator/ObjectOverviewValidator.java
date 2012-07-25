package de.aisy.immo.controller.internet.validator;

import com.gargoylesoftware.htmlunit.WebResponse;
import de.aisy.immo.controller.internet.step.ResponseValidator;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 21:00
 * To change this template use File | Settings | File Templates.
 */
public class ObjectOverviewValidator implements ResponseValidator {

    public boolean isExceptedResponse(WebResponse response) {

        //TODO
        return response.getContentAsString().contains("Angebotsübersicht");
    }
}
