package de.aisy.immo.controller.internet;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class FormData {

    public static enum RequestMethod {

        GET,
        POST,
        PUT,
        DELETE
    }

    private RequestMethod requestMethod;

    private String url;

    private List<NameValuePair> parameters;

    public FormData(RequestMethod requestMethod, String url, List<NameValuePair> parameters) {
        this.requestMethod = requestMethod;
        this.url = url;
        this.parameters = parameters;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(RequestMethod requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<NameValuePair> getParameters() {
        return parameters;
    }

    public void setParameters(List<NameValuePair> parameters) {
        this.parameters = parameters;
    }
}
