package RequestData;

import ParseXML.ParseXMLAllSeasons;
import java.util.HashMap;

public class SeasonListRequest extends Request {

    private final String ALL_SEASONS = "seasons?limit=1000";

    public SeasonListRequest() {
        super(); // call super constructor to run the tag names
        super.queryURL = super.BASE_URL + this.ALL_SEASONS;
        System.out.println("---Every F1 Season---");
        displayDetails();
    }

    @Override
    public void setTagName() {
        super.tagName = "SeasonTable";
    }

    @Override
    public void setElementName() {
        super.elementName = "Season";
    }

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
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

}
