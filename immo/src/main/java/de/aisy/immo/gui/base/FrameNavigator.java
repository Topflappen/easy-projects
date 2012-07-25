package de.aisy.immo.gui.base;

import de.aisy.immo.constants.GUIConstants;
import de.aisy.immo.gui.FrameNavigatorObservable;
import de.aisy.immo.gui.base.event.PopFrameEvent;
import de.aisy.immo.gui.base.event.PushFrameEvent;
import de.aisy.immo.gui.base.event.ReplaceFrameEvent;
import de.framework.commons.util.ThreadUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 16:34
 * To change this template use File | Settings | File Templates.
 */
public class FrameNavigator extends JFrame implements Observer {

    private Stack<JPanel> frameStack = new Stack<JPanel>();

    private JPanel mainPanel;

    public FrameNavigator(int width, int height) throws HeadlessException {
        super();
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.mainPanel = new JPanel();
        this.mainPanel.setSize(width, height);
        this.mainPanel.setVisible(true);
        this.add(mainPanel);

        FrameNavigatorObservable.getInstance().addObserver(this);
    }

    public void update(Observable observable, Object o) {

        if(o instanceof PushFrameEvent) {

            final PushFrameEvent pushFrameEvent = (PushFrameEvent) o;

            if(pushFrameEvent.getFrame() == null) {
                return;
            }

            if(!frameStack.empty()) {

                if(this.frameStack.peek().equals(pushFrameEvent.getFrame())) {
                    return;
                }

                this.mainPanel.remove(this.frameStack.peek());
            }


            this.mainPanel.add(pushFrameEvent.getFrame());
            this.frameStack.push(pushFrameEvent.getFrame());
            pushFrameEvent.getFrame().setVisible(true);

            ThreadUtil.runDelayed(500, new ThreadUtil.Action() {
                public void execute() {
                    pushFrameEvent.getFrame().onBecomeActive(pushFrameEvent.getData());
                }
            });
        }

        if(o instanceof PopFrameEvent) {

            PopFrameEvent popFrameEvent = (PopFrameEvent) o;

            if(frameStack.empty()) {
                return;
            }

            JPanel frame = frameStack.pop();
            this.mainPanel.remove(frame);

            if(frameStack.empty()) {
                return;
            }

            this.mainPanel.add(frameStack.peek());
            frameStack.peek().setVisible(true);

        }

        if(o instanceof ReplaceFrameEvent) {

            final ReplaceFrameEvent replaceFrameEvent = (ReplaceFrameEvent) o;

            if(!frameStack.empty()) {

                //this.remove();
                this.mainPanel.remove(frameStack.peek());
            }

            frameStack.clear();

            if(replaceFrameEvent.getFrame() == null) {
                return;
            }

            replaceFrameEvent.getFrame().setVisible(true);
            this.mainPanel.add(replaceFrameEvent.getFrame());
            this.frameStack.push(replaceFrameEvent.getFrame());

            ThreadUtil.runDelayed(500, new ThreadUtil.Action() {
                public void execute() {
                    replaceFrameEvent.getFrame().onBecomeActive(replaceFrameEvent.getData());
                }
            });


        }

        this.mainPanel.revalidate();
        this.mainPanel.repaint();
    }
}
