package de.aisy.immo.gui.base.event;

import de.aisy.immo.gui.base.PagePanel;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 16:49
 * To change this template use File | Settings | File Templates.
 */
public class ReplaceFrameEvent {

    private PagePanel frame;

    private Object data;

    public ReplaceFrameEvent(PagePanel frame) {
        this.frame = frame;
    }

    public ReplaceFrameEvent(PagePanel frame, Object data) {
        this.frame = frame;
        this.data = data;
    }

    public PagePanel getFrame() {
        return frame;
    }

    public Object getData() {
        return data;
    }
}
