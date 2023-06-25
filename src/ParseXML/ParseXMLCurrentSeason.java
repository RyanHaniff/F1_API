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
    int count = 0;

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

            Element raceElement = doc.getDocumentElement();
            NodeList nodeList = raceElement.getChildNodes();

            iterateNodes(nodeList);

            // NodeList childElementsInRace = raceElement.getChildNodes();

            // for (int i = 0; i < childElementsInRace.getLength(); i++) {
            // String text = childElementsInRace.item(i).getTextContent();
            // text = text.trim();
            // System.out.println("test");
            // System.out.println(text);
            // count++;
            // }

            // ordered collection of nodes
            // NodeList nodeElements = doc.getElementsByTagName(PARENT_NODE); // RaceTable
            // for (int i = 0; i < nodeElements.getLength(); i++) {
            // // getting the parent node
            // Node node = nodeElements.item(i);
            // if (node.getNodeType() == Node.ELEMENT_NODE) {
            // Element eElement = (Element) node;
            // System.out.println(
            // (i + 1) + "\t" +
            // eElement.getElementsByTagName(RACE_NAME).item(0).getTextContent()); //
            // "RaceName"
            // System.out.println(
            // (i + 1) + "\t" +
            // eElement.getElementsByTagName(DATE).item(0).getTextContent());
            // System.out.println(
            // (i + 1) + "\t" + eElement.getAttribute(ROUND_ATTRIBUTE));
            // // xmlHashMap.put(i,
            // // eElement.getElementsByTagName(elementName).item(0).getTextContent());
            // }
            // }

        } catch (Exception e) {
            System.out.println("Exception at readXML(): " + e);
        }
        System.out.println(count);

    }

    private static void iterateNodes(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                if (node.getNodeName() == RACE_NAME) {
                    System.out.println("Node Value: " + node.getTextContent());
                }
                // System.out.println("Node Name: " + node.getNodeName());
                // System.out.println("Node Value: " + node.getTextContent());

                if (node.hasChildNodes()) {
                    iterateNodes(node.getChildNodes());
                }
            }
        }
    }

    @Override
    public void printTable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printTable'");
    }

}
