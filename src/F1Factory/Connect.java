package F1Factory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class Connect {

    protected final String BASE_URL = "https://ergast.com/api/f1/";
    protected String queryURL = "";

    public void displayDetails(String queryURL) {
        try {
            ParseXML.readXML(getRequest(queryURL));
        } catch (Exception e) {
            System.out.println("Exception at displayDetails(): " + e);
        }
    }

    public String getRequest(String queryURL) throws IOException, InterruptedException {
        // GET request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(queryURL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public abstract String toString();

}
