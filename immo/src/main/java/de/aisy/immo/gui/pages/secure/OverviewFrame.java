package de.aisy.immo.gui.pages.secure;

import de.aisy.immo.controller.internet.step.impl.ListObjectsStep;
import de.aisy.immo.controller.internet.step.Step;
import de.aisy.immo.controller.internet.step.StepExecutor;
import de.aisy.immo.gui.base.PagePanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public class OverviewFrame extends PagePanel implements StepExecutor.ResultHandler<List<String>> {

    private static OverviewFrame instance;

    private JTextArea textArea;

    public static OverviewFrame getInstance() {

        if(instance == null) {
            instance = new OverviewFrame();
        }

        return instance;
    }

    private OverviewFrame() throws HeadlessException {
        init();
    }

    private void init() {

        this.setSize(100, 100);
        this.textArea = new JTextArea();
        this.textArea.setText("Objekte werden geladen...");
        textArea.setBackground(getBackground());
        this.add(textArea);
    }


    @Override
    public void onBecomeActive(Object data) {
        StepExecutor.getInstance().executeStep(true, new ListObjectsStep(), this);
    }

    public void onExecuted(Step.Result result, Step<List<String>> step) {

        if(result.equals(Step.Result.SUCCESS)) {

            List<String> objects = step.getResult();

            StringBuilder stringBuilder = new StringBuilder();

            for(String object: objects) {
                stringBuilder.append(object).append("\n");
            }

            this.textArea.setText(stringBuilder.toString());
        }

    }
}
