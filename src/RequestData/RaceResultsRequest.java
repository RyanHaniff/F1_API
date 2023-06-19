package RequestData;

import ParseXML.ParseXML;

public class RaceResultsRequest extends Request {

    private final String LATEST_RACE_RESULTS = "current/last/results";

    public RaceResultsRequest() {
        super();
        super.queryURL = super.BASE_URL + this.LATEST_RACE_RESULTS;
        System.out.println("---Latest Race Results---");
        displayDetails();
    }

    @Override
    public void setTagName() {
        super.tagName = "Result";
    }

    @Override
    public void setElementName() {
        super.elementName = "FamilyName";
    }

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
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

}
