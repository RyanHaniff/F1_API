package RequestData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class Request {

    /**
     * The base url for all API calls to ergast
     */
    protected final String BASE_URL = "https://ergast.com/api/f1/";

    /**
     * The URL that gets concatenated to the {@link Request#BASE_URL} for specific
     * API calls to ergast
     */
    protected String queryURL = "";

    /**
     * Used to access the parent tag of the returned XML file from
     * {@link Request#displayDetails()}
     */
    protected String tagName;

    /**
     * Used to access the child tag of the returned XML file from
     * {@link Request#displayDetails()}
     */
    protected String elementName;

    /**
     * Called from all sub class constructors to instantiate {@link Request#tagName}
     * and {@link Request#elementName}
     */
    public Request() {
        setTagName();
        setElementName();
    }

    /**
     * 
     * @param queryURL The URL that gets concatenated to the BASE_URL for specific
     *                 API calls to ergast
     * @return The XML that gets returned from ergast. Used by
     *         {@link Request#displayDetails()} to get class specific information
     * @throws IOException
     * @throws InterruptedException
     */
    public String getRequest(String queryURL) throws IOException, InterruptedException {
        // GET request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(queryURL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    /**
     * Set the {@link Request#tagName} for child class
     */
    public abstract void setTagName();

    /**
     * Set the {@link Request#elementName} for child classes
     */
    public abstract void setElementName();

    /**
     * Calls {@link Request#getClass()} and {@link ParseXML#readXML()} to display
     * all details from query
     */
    public abstract void displayDetails();

    public abstract String toString();
}
