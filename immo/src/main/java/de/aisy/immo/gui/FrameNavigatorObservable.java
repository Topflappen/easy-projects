package de.aisy.immo.gui;

import de.aisy.immo.gui.base.PagePanel;
import de.aisy.immo.gui.base.event.PopFrameEvent;
import de.aisy.immo.gui.base.event.PushFrameEvent;
import de.aisy.immo.gui.base.event.ReplaceFrameEvent;

import java.util.Observable;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 */
public class FrameNavigatorObservable extends Observable {
    private static FrameNavigatorObservable ourInstance = new FrameNavigatorObservable();

    public static FrameNavigatorObservable getInstance() {
        return ourInstance;
    }

    private FrameNavigatorObservable() {
    }

    public void pushPage(PagePanel jFrame) {
        this.pushPage(jFrame, null);
    }

    public void pushPage(PagePanel jFrame, Object data) {
        this.setChanged();
        this.notifyObservers(new PushFrameEvent(jFrame, data));
    }

    public void replacePage(PagePanel pagePanel) {
        this.replacePage(pagePanel, null);
    }

    public void replacePage(PagePanel jFrame, Object data) {
        this.setChanged();
        this.notifyObservers(new ReplaceFrameEvent(jFrame, data));
    }

    public void popPage() {
        this.setChanged();
        this.notifyObservers(new PopFrameEvent());
    }

}
