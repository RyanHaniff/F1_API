import Factory.SeasonFactory;
import Factory.Season;

public class Main {

    public static void main(String[] args) {

        SeasonFactory seasonFactory = new SeasonFactory();
        seasonFactory.createConnection("");
        seasonFactory.createConnection("2013");

    }

}
