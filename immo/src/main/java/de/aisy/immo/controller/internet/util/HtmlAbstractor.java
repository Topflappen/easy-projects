package de.aisy.immo.controller.internet.util;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */
public class HtmlAbstractor {

    public static List<HtmlElement> getElementByTagName(Object object, String tagName) {

        if(object == null) {
            return new ArrayList<HtmlElement>();
        }

        if(object instanceof HtmlElement) {
            return ((HtmlElement) object).getHtmlElementsByTagName(tagName);
        }

        if(object instanceof HtmlPage) {
            return ((HtmlPage) object).getElementsByTagName(tagName);
        }

        return new ArrayList<HtmlElement>();
    }

    public static HtmlElement getElementById(Object object, String id) {

        if(object == null) {
            return null;
        }

        if(object instanceof HtmlElement) {
            return ((HtmlElement) object).getElementById(id);
        }

        if(object instanceof HtmlPage) {
            return ((HtmlPage) object).getElementById(id);
        }

        return null;
    }

}
