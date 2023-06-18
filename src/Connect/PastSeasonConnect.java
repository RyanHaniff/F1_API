package Connect;

public class PastSeasonConnect extends Connect {

    private String seasonNumber;

    public PastSeasonConnect(int seasonNumber) {
        this.seasonNumber = Integer.toString(seasonNumber);
        super.queryURL = super.BASE_URL + seasonNumber;
        super.displayDetails(queryURL);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
