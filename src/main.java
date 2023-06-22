import Factory.F1ResultsFactory;
import RequestData.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class main {

    public static void main(String[] args) {

        // Create teh F1 factory
        F1ResultsFactory factory = new F1ResultsFactory();

        // factory.createConnection("");
        // System.out.println("========================");
        // Pass in a string of what information you want to get
        factory.createConnection("2013");
        factory.createConnection("season");
        factory.createConnection("latest race results");
        factory.createConnection("latest qualifying results");

        /* Used for testing xml response */
        // http://ergast.com/api/f1/seasons
        // http://ergast.com/api/f1/current
        // http://ergast.com/api/f1/current/last/results
        // https://ergast.com/api/f1/current/last/qualifying

        // try {
        // System.out.println(g
        // } catch (Exception e) {
        // System.out.println(e);
        // }

    }

    // Used for testing xml response
    public static String getRequest(String queryURL) throws IOException, InterruptedException {
        // GET request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(queryURL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
