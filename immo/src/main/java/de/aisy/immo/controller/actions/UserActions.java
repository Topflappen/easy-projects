package de.aisy.immo.controller.actions;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import de.aisy.immo.controller.internet.step.Step;
import de.aisy.immo.controller.internet.step.StepExecutor;
import de.aisy.immo.controller.internet.step.impl.LoginStep;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
public class UserActions {
    private static UserActions ourInstance = new UserActions();

    public static UserActions getInstance() {
        return ourInstance;
    }

    private UserActions() {
    }

    public Step.Result login(String username, String password) {

        HtmlPage loginPage = InternetActions.getInstance().getLoginPage();

        if(loginPage == null) {
            return Step.Result.FAILURE_COULD_NOT_LOAD_PAGE;
        }

        LoginStep loginStep = new LoginStep(loginPage, username, password);

        return StepExecutor.getInstance().executeStep(true, loginStep);
    }

}
