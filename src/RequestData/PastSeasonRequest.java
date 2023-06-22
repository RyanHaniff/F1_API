package RequestData;

import ParseXML.ParseXML;

/**
 * Displays a table of all the races for the specified season, past into the
 * constructor
 * Ex: http://ergast.com/api/f1/2013
 */
public class PastSeasonRequest extends Request {

    /**
     * Integer that gets concatnated to {@link Request#BASE_URL} to show all races
     * of that seaason
     */
    private String seasonNumber;

    /**
     * * Constructor call to base class to instantiate
     * {@link SeasonListRequest#setTagName()} and
     * {@link SeasonListRequest#setElementName()}
     * When the class is instantiated, it will automatically display the results
     * to console
     * 
     * @param seasonNumber The season that you want to query
     * 
     */
    public PastSeasonRequest(int seasonNumber) {
        super();
        this.seasonNumber = Integer.toString(seasonNumber);
        super.queryURL = super.BASE_URL + seasonNumber;
        System.out.println("---" + seasonNumber + " Season List---");
        displayDetails();
    }

    /**
     * Showing the results of the query to the console. Can later be used for data
     * anlysis.
     * Call to ParseXML is made for a default XML response from ergast.
     */
    @Override
    public void displayDetails() {
        try {
            String xmlResponse = getRequest(queryURL);
            ParseXML.readXML(xmlResponse, super.tagName, super.elementName);
        } catch (Exception e) {
            System.out.println("Exception at displayDetails(): " + e);
        }
    }

    @Override
    public void setTagName() {
        super.tagName = "Race";
    }

    @Override
    public void setElementName() {
        super.elementName = "RaceName";
    }

}
