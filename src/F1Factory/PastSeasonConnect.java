package F1Factory;

public class PastSeasonConnect extends Connect {

    private String seasonNumber;

    public PastSeasonConnect(int seasonNumber) {
        this.seasonNumber = Integer.toString(seasonNumber);
    }

    @Override
    public String getRequest() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRequest'");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }
}
