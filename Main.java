import java.awt.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String args[]) throws AWTException, IOException {
        NotificationHandler.setupNotifier();
        Config.parseConfig();
        Timer timer = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run () {
                try {
                    PriceParser.setCasePrice();
                    NotificationHandler.displayNotification();
                    NotificationHandler.displayConsole();
                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.scheduleAtFixedRate(tt, 0L, Config.getInterval() * 1000);
    }
}
