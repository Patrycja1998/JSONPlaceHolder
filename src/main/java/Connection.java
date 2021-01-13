import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;


public class Connection {

    private String url;

    public Connection(String url) {
        this.url = url;
    }

    public String getConnection() throws IOException {


        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(request);

            try {
            StringBuilder responseCode = new StringBuilder();
            responseCode.append("Response code: ");
            responseCode.append(response.getStatusLine().getStatusCode());
            responseCode.append(" ");
            responseCode.append(response.getStatusLine().getReasonPhrase());
            System.out.println(responseCode.toString());


            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                return result;
            }
            return "Body response is empty";
        }
            finally {
                response.close();
            }
        }
        finally {
            httpClient.close();
        }
    }
}



