import java.io.*;
import java.util.ArrayList;



public class Main {

    public static void main(String[] args) throws IOException {

        Connection connection = new Connection("https://jsonplaceholder.typicode.com/posts");
        JSONParser jsonParser = new JSONParser(connection.getConnection());
        ArrayList<Post> posts = jsonParser.parseFromJSONToPost();
        jsonParser.parseFromPostToJSON(posts);

        }

    }



