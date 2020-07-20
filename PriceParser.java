import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PriceParser {

    public static final String API_STRING = Config.getItemURL();
    static URL url;
    static String json;
    public static double casePrice;

    public static double setCasePrice() {
        JSONParser parser = new JSONParser();
        try {
            url = new URL(API_STRING);
            Scanner s = new Scanner(url.openStream());
            json = s.nextLine();
            s.close();
            JSONObject obj = (JSONObject) parser.parse(json);
            casePrice = Double.parseDouble(((String) obj.get("lowest_price")).replace("zł", "").replace(",", "."));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return casePrice;
    }

    public static double getWholePrice() {
        double x = casePrice;
        double y = Double.parseDouble(Config.getAmountOfCases());
        DecimalFormat df = new DecimalFormat("###.##");
        return Double.parseDouble(df.format(x * y).replace(",", "."));
    }

}
