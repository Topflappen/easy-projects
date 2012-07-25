package de.aisy.immo.gui.util;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 16:19
 * To change this template use File | Settings | File Templates.
 */
public class ButtonBuilder {

    private JButton result;

    public ButtonBuilder() {
        this.result = new JButton();
    }

    public ButtonBuilder(String label) {
        this.result = new JButton(label);
    }

    public ButtonBuilder addActionListener(ActionListener actionListener) {
        this.result.addActionListener(actionListener);
        return this;
    }

    public JButton getResult() {
        return result;
    }
}
