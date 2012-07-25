package de.aisy.immo.gui.base;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
public abstract class PagePanel extends JPanel {

    public PagePanel(LayoutManager layoutManager, boolean b) {
        super(layoutManager, b);
    }

    public PagePanel(LayoutManager layoutManager) {
        super(layoutManager);
    }

    public PagePanel(boolean b) {
        super(b);
    }

    public PagePanel() {
    }

    public abstract void onBecomeActive(Object data);
}
