package de.aisy.immo.gui;

import de.aisy.immo.constants.GUIConstants;
import de.aisy.immo.gui.base.FrameNavigator;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
public class MainFrameNavigator extends FrameNavigator {

    public MainFrameNavigator(int width, int height) throws HeadlessException {
        super(width, height);
        init();
    }

    private void init() {

        setTitle(GUIConstants.APPLICATION_NAME);
    }

}
