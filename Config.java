import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Config {

    public static String amountOfCases;
    public static Long interval;
    public static String notificationPrice;
    public static String json;
    public static String itemurl;
    public static double price;

    public static String getAmountOfCases() {
        return amountOfCases;
    }

    public static Long getInterval() {
        return interval;
    }

    public static String getNotificationPrice() {
        return notificationPrice;
    }

    public static String getItemURL() {
        return itemurl;
    }

    public static void parseConfig() {
        JSONParser parser = new JSONParser();
        Scanner s = null;
        try {
            s = new Scanner(new File("./config.json"));
            json = s.nextLine();
            s.close();
            JSONObject obj = (JSONObject) parser.parse(json);
            amountOfCases = (String) obj.get("amountofcases");
            interval = (Long) obj.get("interval");
            notificationPrice = (String) obj.get("notificationprice");
            itemurl = (String) obj.get("itemurl");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
