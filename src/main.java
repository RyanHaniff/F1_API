import Factory.SeasonFactory;
import Factory.Season;

public class Main {

    public static void main(String[] args) {

        SeasonFactory seasonFactory = new SeasonFactory();
        Season current = seasonFactory.createConnection("");
        System.out.println(current);
    }

}
