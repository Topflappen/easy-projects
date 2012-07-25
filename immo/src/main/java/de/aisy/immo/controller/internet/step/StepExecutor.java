package de.aisy.immo.controller.internet.step;

import de.aisy.immo.controller.actions.InternetActions;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 20:04
 * To change this template use File | Settings | File Templates.
 */
public class StepExecutor {

    public static interface ResultHandler<T> {

        void onExecuted(Step.Result result, Step<T> step);

    }

    private static StepExecutor ourInstance = new StepExecutor();

    public static StepExecutor getInstance() {
        return ourInstance;
    }

    private StepExecutor() {
    }

    public <T> Step.Result executeStep(boolean trackPage, Step<T> step) {
        return this.executeStep(trackPage, step, null);
    }

    public <T> Step.Result executeStep(boolean trackPage, Step<T> step, ResultHandler<T> resultHandler) {

        Step.Result result = step.proceed();

        if(trackPage) {
            InternetActions.getInstance().updateCurrentPage(step.getFollowUpPage());
        }

        if(resultHandler != null) {
            resultHandler.onExecuted(result, step);
        }
        return result;
    }


}
