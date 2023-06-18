import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import Connect.ParseXML;

public class HTTP_Connect {

    private static String BASE_URL = "https://ergast.com/api/f1/";
    private static String CURRENT = "current";
    private String queryURL = "";

    public HTTP_Connect() {
        this.queryURL = BASE_URL + CURRENT;
    }

    public HTTP_Connect(String season) {
        this.queryURL = BASE_URL + season;
        displayDetails();

    }

    public HTTP_Connect(String season, String round) {
        this.queryURL = BASE_URL + season + "/" + round;
        displayDetails();

    }

    // if they enter a string for the round, convert it to a number to query the
    // result
    public void displayDetails() {
        try {
            ParseXML.readXML(getRequest());
        } catch (Exception e) {
            System.out.println("Exception at displayDetails(): " + e);
        }
    }

    private String getRequest() throws IOException, InterruptedException {
        // GET request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(queryURL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
