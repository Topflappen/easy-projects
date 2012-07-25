package de.aisy.immo.controller.internet.step.impl;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import de.aisy.immo.constants.ImmoscoutPageConstants;
import de.aisy.immo.controller.internet.step.BaseStep;
import de.aisy.immo.controller.internet.util.Finder;
import de.aisy.immo.controller.internet.validator.LoginResponseValidator;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 15:21
 * To change this template use File | Settings | File Templates.
 */
public class LoginStep extends BaseStep {

    private String username;
    private String password;
    private HtmlPage htmlPage;

    public LoginStep(HtmlPage htmlPage, String username, String password) {
        super(new LoginResponseValidator());

        this.username = username;
        this.password = password;
        this.htmlPage = htmlPage;
    }

    @Override
    protected HtmlPage proceedImpl() throws IOException {

        HtmlPage finalPage = htmlPage;

        HtmlElement usernameInput = Finder.findIn(finalPage).byId(ImmoscoutPageConstants.LOGIN_USERNAME_INPUT_ID).singleResult();
        HtmlElement passwordInput = Finder.findIn(finalPage).byId(ImmoscoutPageConstants.LOGIN_PASSWORD_INPUT_ID).singleResult();

        if(usernameInput == null || passwordInput == null) {
            return null;
        }

        usernameInput.type(username);
        passwordInput.type(password);

        HtmlElement loginButton = Finder.findIn(htmlPage).byTag("input").filter().byAttributeValue("value", ImmoscoutPageConstants.LOGIN_BUTTON_VALUE).singleResult();

        if(loginButton == null) {
            return null;
        }

        return loginButton.click();
    }

    @Override
    protected Object produceResult(HtmlPage htmlPage) {
        return "Login was successful!";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HtmlPage getHtmlPage() {
        return htmlPage;
    }

    public void setHtmlPage(HtmlPage htmlPage) {
        this.htmlPage = htmlPage;
    }

}
