package RequestData;

import ParseXML.ParseXML;
import ParseXML.ParseXMLCurrentSeason;

/**
 * Displays a table of all the races to be held within the current year.
 */
public class CurrentSeasonRequest extends Request {

    /**
     * String that gets concatnated to {@link Request#BASE_URL} to get all races
     * this season.
     */
    private final String CURRENT = "current";

    /**
     * Constructor call to base class to instantiate
     * {@link SeasonListRequest#setTagName()} and
     * {@link SeasonListRequest#setElementName()}
     * When class is instantiated it will automatically display the results to
     * console
     */
    public CurrentSeasonRequest() {
        super(); // call super constructor to run the tag names
        super.queryURL = super.BASE_URL + this.CURRENT;
        System.out.println("---Current Season List---");
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

            ParseXML parse = new ParseXMLCurrentSeason();
            parse.readXML(xmlResponse);

            // ParseXML.readXML(xmlResponse, super.tagName, super.elementName);
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
