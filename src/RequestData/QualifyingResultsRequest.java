package RequestData;

import ParseXML.ParseXML;

public class QualifyingResultsRequest extends Request {

    private final String LATEST_QUALIFYING_RESULTS = "current/last/qualifying";

    public QualifyingResultsRequest() {
        super();
        super.queryURL = super.BASE_URL + this.LATEST_QUALIFYING_RESULTS;
        System.out.println("---Latest Qualifying Results---");
        displayDetails();
    }

    @Override
    public void setTagName() {
        super.tagName = "QualifyingResult";
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
