package de.aisy.immo.controller.internet.step;

import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 15:19
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseStep<T> extends Step<T> {

    private ResponseValidator responseValidator;

    private HtmlPage followUpPage;

    private T result;

    public BaseStep(ResponseValidator responseValidator) {
        this.responseValidator = responseValidator;
    }

    Result proceed() {

        HtmlPage resultPage = null;
        try {
            resultPage = proceedImpl();
        } catch (IOException e) {
            return Result.FAILURE_COULD_NOT_LOAD_PAGE;
        }

        if(resultPage == null) {
            return Result.FAILURE_UNEXPECTED_LAYOUT;
        }

        this.followUpPage = resultPage;

        WebResponse response = resultPage.getWebResponse();

        if(response == null) {
            return Result.FAILURE_COULD_NOT_LOAD_PAGE;
        }

        if(responseValidator.isExceptedResponse(response)) {

            this.result = produceResult(resultPage);

            return Result.SUCCESS;
        }

        return Result.FAILURE_WRONG_RESPONSE;
    }

    protected abstract HtmlPage proceedImpl() throws IOException;

    protected abstract T produceResult(HtmlPage htmlPage);

    public ResponseValidator getResponseValidator() {
        return responseValidator;
    }

    public HtmlPage getFollowUpPage() {
        return followUpPage;
    }

    @Override
    public T getResult() {
        return result;
    }
}
