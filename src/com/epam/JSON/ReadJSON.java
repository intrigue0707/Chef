package com.epam.JSON;
import com.epam.Products.Salad;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Maryia on 11/16/2015.
 */
public class ReadJSON {


public static double ReadJSON(String category, String name) throws IOException, JSONException {
     String Jsonfile = "src/com/epam/JSON/MySalad.json";
     String result = "";
     String line;

    BufferedReader br = new BufferedReader(new FileReader(Jsonfile));
    while ((line = br.readLine()) != null) {
        result += line + "\n";
    }
    br.close();
    JSONObject obj = new JSONObject(result);
    return obj.getJSONObject("Salad").getJSONObject(category).getJSONObject(name).getDouble("calories");

}


}