import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main {

    public static void main(String[] args) throws IOException {


        String url = "https://jsonplaceholder.typicode.com/posts";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();



        int responseCode = con.getResponseCode();
        System.out.println("Response code" + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);

        }



        in.close();

        JSONArray jsonarray = new JSONArray(response.toString());
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            int userId = jsonobject.getInt("userId");
            int id = jsonobject.getInt("id");
            String title = jsonobject.getString("title");
            String body = jsonobject.getString("body");

            FileWriter fileWriter = new FileWriter("'" + id + ".json");
            fileWriter.write(String.valueOf(jsonobject));
            fileWriter.flush();



        }

    }


}
