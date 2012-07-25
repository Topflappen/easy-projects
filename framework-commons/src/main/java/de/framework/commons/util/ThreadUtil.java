package de.framework.commons.util;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by IntelliJ IDEA.
 * User: Clemens Wichert
 * Date: 23.07.12
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class ThreadUtil {

    public static interface Action {

        void execute();
    }

    public static void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public static void runInThread(final Action action) {

        new Thread() {

            @Override
            public void run() {
                action.execute();
            }

        }.run();
    }

    public static void runDelayed(int delay, final Action action) {

        final Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                action.execute();
                timer.cancel();
            }
        };

        timer.schedule(timerTask, delay);

    }

}
