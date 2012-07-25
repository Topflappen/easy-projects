package de.aisy.immo.controller.internet.validator;

import com.gargoylesoftware.htmlunit.WebResponse;
import de.aisy.immo.constants.ImmoscoutPageConstants;
import de.aisy.immo.controller.internet.step.ResponseValidator;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 */
public class LoginResponseValidator implements ResponseValidator {

    public boolean isExceptedResponse(WebResponse response) {

        String result = response.getContentAsString();

        if(result.contains(ImmoscoutPageConstants.LOGIN_FAILED_MESSAGE)) {
            return false;
        }

        return true;
    }
}
