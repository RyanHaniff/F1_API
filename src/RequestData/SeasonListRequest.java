package RequestData;

import ParseXML.ParseXMLAllSeasons;
import java.util.HashMap;

/**
 * Displays a list of all documented seasons in years as shown in
 * http://ergast.com/api/f1/seasons
 */
public class SeasonListRequest extends Request {

    /**
     * String that gets concatnated to {@link Request#BASE_URL} to show all seasons
     * on one page.
     * Max seasons arbitrarily set to 1000
     */
    private final String ALL_SEASONS = "seasons?limit=1000";

    /**
     * Constructor call to base class to instantiate
     * {@link SeasonListRequest#setTagName()} and
     * {@link SeasonListRequest#setElementName()}
     * When the class is instantiated, it will automatically display the results to
     * console
     */
    public SeasonListRequest() {
        super(); // call super constructor to run the tag names
        super.queryURL = super.BASE_URL + this.ALL_SEASONS;
        System.out.println("---Every F1 Season---");
        displayDetails();
    }

    /**
     * Showing the results of the query to the console. Can later be used for data
     * anlysis.
     * A call to ParseXMLAllSeasons because of th different XML response from ergast
     */
    @Override
    public void displayDetails() {
        try {
            String xmlResponse = getRequest(queryURL);
            HashMap<Integer, String> allSeasonsHash = ParseXMLAllSeasons.readXML(xmlResponse);
            // System.out.println("test: " + allSeasonsHash.get);
            // System.out.println("Total Number of Seasons: " + allSeasonsHash.size());
            // System.out.println("seasons: " + allSeasonsHash);
        } catch (Exception e) {
            System.out.println("Exception at displayDetails(): " + e);
        }
    }

    @Override
    public void setTagName() {
        super.tagName = "SeasonTable";
    }

    @Override
    public void setElementName() {
        super.elementName = "Season";
    }

}
