package de.aisy.immo.controller.internet.util;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
public class Finder {

    public static Finder findIn(HtmlPage htmlPage) {
        return new Finder(htmlPage);
    }

    public static Finder findIn(HtmlElement htmlPage) {
        return new Finder(htmlPage);
    }

    public class Filter {

        private List<HtmlElement> elements;

        private Filter(List<HtmlElement> elements) {
            this.elements = elements;
        }

        public Finder findInSingleResult() {
            return Finder.findIn(singleResult());
        }

        public Filter byAttribute(String attribute) {

            List<HtmlElement> newElements = new ArrayList<HtmlElement>();

            for(HtmlElement htmlElement: elements) {

                if(htmlElement.hasAttribute(attribute)) {
                    newElements.add(htmlElement);
                }
            }

            this.elements = newElements;

            return this;
        }

        public Filter byAttributeValue(String attribute, String value) {

            List<HtmlElement> newElements = new ArrayList<HtmlElement>();

            for(HtmlElement htmlElement: elements) {

                if(htmlElement.hasAttribute(attribute) && htmlElement.getAttribute(attribute).equals(value)) {
                    newElements.add(htmlElement);
                }
            }

            this.elements = newElements;

            return this;
        }

        public Filter byAttributeValueLike(String attribute, String valueLike) {

            List<HtmlElement> newElements = new ArrayList<HtmlElement>();

            for (HtmlElement htmlElement : elements) {

                if (htmlElement.hasAttribute(attribute) && htmlElement.getAttribute(attribute).contains(valueLike)) {
                    newElements.add(htmlElement);
                }
            }

            this.elements = newElements;

            return this;
        }

        public Filter byAttributeValueStartsWith(String attribute, String valueStartsWith) {

            List<HtmlElement> newElements = new ArrayList<HtmlElement>();

            for (HtmlElement htmlElement : elements) {

                if (htmlElement.hasAttribute(attribute) && htmlElement.getAttribute(attribute).startsWith(valueStartsWith)) {
                    newElements.add(htmlElement);
                }
            }

            this.elements = newElements;

            return this;

        }

        public List<HtmlElement> results() {
            return elements;
        }

        public HtmlElement singleResult() {

            if (elements.isEmpty()) {
                return null;
            }

            return elements.get(0);
        }

    }

    private Object htmlPage;

    private List<HtmlElement> result = new ArrayList<HtmlElement>();

    private Finder(HtmlPage htmlPage) {
        this.htmlPage = htmlPage;
    }

    private Finder(HtmlElement htmlPage) {
        this.htmlPage = htmlPage;
    }

    public Finder findInSingleResult() {
        return new Finder(singleResult());
    }

    public Finder byTag(String tag) {

        result.addAll(HtmlAbstractor.getElementByTagName(htmlPage, tag));
        return this;
    }

    public Finder byId(String id) {

        HtmlElement htmlElement = HtmlAbstractor.getElementById(htmlPage, id);

        if(htmlElement != null) {
            result.add(htmlElement);
        }

        return this;
    }

    public Filter filter() {
        return new Filter(this.result);
    }

    public HtmlElement singleResult() {

        if(result.isEmpty()) {
            return null;
        }

        return result.get(0);
    }

    public List<HtmlElement> results() {
        return result;
    }
}
