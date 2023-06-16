import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;

public class ParseXML {

    private String xmlString;

    public static void readXML(String xmlFile) {

        // an instance of factory that gives a document builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to create a documentbuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            StringReader stringReader = new StringReader(xmlFile);
            InputSource inInputSource = new InputSource(stringReader);
            Document doc = builder.parse(inInputSource);

            // // get the first element
            // Element elem = doc.getDocumentElement();

            // // get all child nodes
            // NodeList nodes = elem.getChildNodes();

            // // print the text of each child node
            // for (int i = 0; i < nodes.getLength(); i++) {

            // System.out.println("" + nodes.item(i).getTextContent());
            // }

            // ordered collection of nodes
            NodeList race = doc.getElementsByTagName("Race");
            for (int i = 0; i < race.getLength(); i++) {
                // getting the parent Race node
                Node node = race.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    System.out.println(eElement.getElementsByTagName("RaceName").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            System.out.println("Exception at readXML(): " + e);
        }
    }

}
