import Factory.F1ResultsFactory;

public class Main {

    public static void main(String[] args) {

        F1ResultsFactory factory = new F1ResultsFactory();
        factory.createConnection("");
        System.out.println("========================");
        factory.createConnection("2013");

    }

}
