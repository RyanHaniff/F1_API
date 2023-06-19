package Connect;

import ParseXML.ParseXML;

public class PastSeasonConnect extends Connect {

    private String seasonNumber;

    public PastSeasonConnect(int seasonNumber) {
        super();
        this.seasonNumber = Integer.toString(seasonNumber);
        super.queryURL = super.BASE_URL + seasonNumber;
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
