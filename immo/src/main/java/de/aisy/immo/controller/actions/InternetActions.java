package de.aisy.immo.controller.actions;

import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import de.aisy.immo.constants.ImmoscoutPageConstants;
import de.aisy.immo.controller.internet.util.Finder;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
public class InternetActions {

    private static InternetActions ourInstance = new InternetActions();

    private WebClient webClient;

    private HtmlPage page;

    public static InternetActions getInstance() {
        return ourInstance;
    }

    private InternetActions() {
        this.webClient = new WebClient();

        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiesEnabled(true);
        webClient.setCookieManager(cookieManager);
        webClient.setJavaScriptEnabled(true);
        webClient.setThrowExceptionOnFailingStatusCode(false);
        webClient.setThrowExceptionOnScriptError(false);
    }

    public HtmlPage getLoginPage() {

        try {
            return webClient.getPage(ImmoscoutPageConstants.PAGE_LOGIN);
        } catch (IOException e) {
            return null;
        }
    }

    public HtmlPage goToObjectsOverview() {

        try {

            HtmlPage homePage = webClient.getPage(ImmoscoutPageConstants.PAGE_HOME);

            HtmlElement overviewLink = Finder.findIn(homePage).byId(ImmoscoutPageConstants.LINK_TO_OBJECTS_ID).singleResult();

            if(overviewLink == null) {
                return null;
            }

            return overviewLink.click();

        } catch (IOException e) {
            return null;
        }
    }

    public void updateCurrentPage(HtmlPage page) {

        if(page != null) {
            this.page = page;
        }
    }

}
