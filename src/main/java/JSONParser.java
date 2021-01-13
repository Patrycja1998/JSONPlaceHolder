import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    private String JSONList;

    public JSONParser(String JSONList) {
        this.JSONList = JSONList;
    }

    public ArrayList parseFromJSONToPost() throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();
        List<Post> objects = objectMapper.readValue(JSONList, new TypeReference<List<Post>>() {
        });
        return (ArrayList) objects;
    }

    public void parseFromPostToJSON(ArrayList<Post> list) throws IOException {

        Gson gson = new Gson();
        for (int i = 0; i < list.size(); i++) {

            FileWriter fileWriter = new FileWriter("" + list.get(i).getId() + ".json");
            fileWriter.write((gson.toJson(list.get(i))));
            fileWriter.flush();

        }

    }

}
