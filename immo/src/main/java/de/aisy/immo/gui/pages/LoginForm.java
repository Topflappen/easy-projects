package de.aisy.immo.gui.pages;

import de.aisy.immo.constants.GUIConstants;
import de.aisy.immo.constants.ImmoscoutPageConstants;
import de.aisy.immo.controller.actions.UserActions;
import de.aisy.immo.controller.internet.step.Step;
import de.aisy.immo.gui.FrameNavigatorObservable;
import de.aisy.immo.gui.base.PagePanel;
import de.aisy.immo.gui.pages.secure.OverviewFrame;
import de.aisy.immo.gui.util.ButtonBuilder;
import de.framework.commons.util.ThreadUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 16:13
 * To change this template use File | Settings | File Templates.
 */
public class LoginForm extends PagePanel {

    private static LoginForm instance;

    public static LoginForm getInstance() {

        if(instance == null) {
            instance = new LoginForm();
        }

        return instance;
    }

    private LoginForm() throws HeadlessException {
        super();
        this.init();
    }

    private void init() {

        setBorder(BorderFactory.createEmptyBorder(50, 5, 5, 5));

        LayoutManager gridLayout = new BoxLayout(this, BoxLayout.Y_AXIS);//new GridLayout(4, 4, 10, 10);
        setLayout(gridLayout);
        final JTextField usernameTextField = new JTextField(20);
        final JPasswordField passwordTextField = new JPasswordField(20);
        final JTextArea resultLabel = new JTextArea(2,2);
        resultLabel.setEditable(false);
        resultLabel.setBackground(getBackground());

        usernameTextField.setText("80056");
        passwordTextField.setText("Kewi65");

        //this.add(Box.createHorizontalGlue());
        add(usernameTextField);
        add(passwordTextField);
        add(resultLabel);

        JButton button = new ButtonBuilder(GUIConstants.LOGIN_BUTTON_LABEL).addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                resultLabel.setText("Bitte warten ...");

                ThreadUtil.runDelayed (10, new ThreadUtil.Action() {
                    public void execute() {
                        Step.Result result = UserActions.getInstance().login(usernameTextField.getText(), new String(passwordTextField.getPassword()));

                        if (result.equals(Step.Result.FAILURE_WRONG_RESPONSE)) {
                            resultLabel.setText(ImmoscoutPageConstants.LOGIN_FAILED_MESSAGE);
                        } else if (result.equals(Step.Result.SUCCESS)) {
                            FrameNavigatorObservable.getInstance().replacePage(OverviewFrame.getInstance());
                        } else {
                            resultLabel.setText("Die Seite war unerreichbar.\nSind Sie mit dem Internet verbunden?");
                        }
                    }
                });

            }
        }).getResult();

        add(button);
    }

    @Override
    public void onBecomeActive(Object data) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
