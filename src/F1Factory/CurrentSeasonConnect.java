package F1Factory;

public class CurrentSeasonConnect extends Connect {

    private final String CURRENT = "current";

    public CurrentSeasonConnect() {
        super.queryURL = super.BASE_URL + this.CURRENT;
        super.displayDetails(queryURL);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

}
