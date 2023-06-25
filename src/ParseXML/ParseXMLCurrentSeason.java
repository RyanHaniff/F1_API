package ParseXML;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ParseXMLCurrentSeason extends ParseXML {

    private static final String PARENT_NODE = "RaceTable";
    private static final String SEASON_NUMBER_ATTRIBUTE = "season";
    private static final String RACE_NAME = "RaceName";
    private static final String DATE = "Date";
    private static final String ROUND_ATTRIBUTE = "round";

    @Override
    public void readXML(String xmlFile) {
        // an instance of factory that gives a document builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to create a documentbuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            StringReader stringReader = new StringReader(xmlFile);
            InputSource inInputSource = new InputSource(stringReader);
            Document doc = builder.parse(inInputSource);

            // ordered collection of nodes
            NodeList nodeElements = doc.getElementsByTagName(PARENT_NODE); // RaceTable
            for (int i = 0; i < nodeElements.getLength(); i++) {
                // getting the parent node
                Node node = nodeElements.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    System.out.println(
                            (i + 1) + "\t" + eElement.getElementsByTagName(RACE_NAME).item(0).getTextContent()); // "RaceName"
                    // xmlHashMap.put(i,
                    // eElement.getElementsByTagName(elementName).item(0).getTextContent());
                }
            }

        } catch (Exception e) {
            System.out.println("Exception at readXML(): " + e);
        }

    }

    @Override
    public void printTable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printTable'");
    }

}
