package Connect;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class Connect {

    protected final String BASE_URL = "https://ergast.com/api/f1/";
    protected String queryURL = "";
    protected String tagName;
    protected String elementName;

    public Connect() {
        setTagName();
        setElementName();
    }

    public String getRequest(String queryURL) throws IOException, InterruptedException {
        // GET request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(queryURL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public abstract void setTagName();

    public abstract void setElementName();

    public abstract void displayDetails();

    public abstract String toString();
}
