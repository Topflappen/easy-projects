package de.aisy.immo.gui.base.event;

import de.aisy.immo.gui.base.PagePanel;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public class PushFrameEvent {

    private PagePanel frame;

    private Object data;

    public PushFrameEvent(PagePanel frame) {
        this.frame = frame;
    }

    public PushFrameEvent(PagePanel frame, Object data) {
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
