import java.awt.*;
import java.text.DecimalFormat;

public class NotificationHandler {

    static TrayIcon trayIcon;

    public static void setupNotifier() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        trayIcon = new TrayIcon(image, "Steam Price Checker");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Steam Price Checker");
        tray.add(trayIcon);
    }

    public static void displayNotification() throws AWTException {
        DecimalFormat df = new DecimalFormat("###.##");
        trayIcon.displayMessage("Cena przedmiotu: " + df.format(PriceParser.itemPrice) + "zł (" + df.format(PriceParser.itemPrice * 0.87D) + "zł)", "Cena twoich wszystkich skrzynek: " + df.format(PriceParser.getWholePrice()) + "zł (" + df.format(PriceParser.getWholePrice() * 0.87D) + "zł)", TrayIcon.MessageType.INFO);
    }

    public static void displayConsole() {
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.println("Cena przedmiotu: " + df.format(PriceParser.itemPrice) + "zł (" + df.format(PriceParser.itemPrice * 0.87D) + "zł)");
        System.out.println("Cena twoich wszystkich przedmiotów: " + df.format(PriceParser.getWholePrice()) + "zł (" + df.format(PriceParser.getWholePrice() * 0.87D) + "zł)");
    }
}
