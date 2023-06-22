package RequestData;

import ParseXML.ParseXML;

/**
 * Displays a table of the latest qualifying results; as shown in:
 * http://ergast.com/api/f1/current/last/qualifying
 */
public class QualifyingResultsRequest extends Request {

    /**
     * String that gets concatnated to {@link Request#BASE_URL} to get latest
     * qualifying results
     */
    private final String LATEST_QUALIFYING_RESULTS = "current/last/qualifying";

    /**
     * Constructor call to base class to instantiate
     * {@link SeasonListRequest#setTagName()} and
     * {@link SeasonListRequest#setElementName()}
     * When the class is instantiated, it will automatically display the results to
     * console
     */
    public QualifyingResultsRequest() {
        super();
        super.queryURL = super.BASE_URL + this.LATEST_QUALIFYING_RESULTS;
        System.out.println("---Latest Qualifying Results---");
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
        super.tagName = "QualifyingResult";
    }

    @Override
    public void setElementName() {
        super.elementName = "FamilyName";
    }

}
