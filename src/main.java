import Factory.SeasonFactory;
import Factory.Season;

public class Main {

    public static void main(String[] args) {

        SeasonFactory seasonFactory = new SeasonFactory();
        seasonFactory.createConnection("");
        System.out.println("========================");
        seasonFactory.createConnection("2013");

    }

}
