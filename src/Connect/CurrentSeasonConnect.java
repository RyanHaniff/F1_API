package Connect;

import ParseXML.ParseXML;

public class CurrentSeasonConnect extends Connect {

    private final String CURRENT = "current";

    public CurrentSeasonConnect() {
        super(); // call super constructor to run the tag names
        super.queryURL = super.BASE_URL + this.CURRENT;
        displayDetails();
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
    public void setTagName() {
        super.tagName = "Race";
    }

    @Override
    public void setElementName() {
        super.elementName = "RaceName";
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

}
