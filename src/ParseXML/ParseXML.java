package ParseXML;

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
import java.util.HashMap;

public abstract class ParseXML {

    private String xmlString;

    public static HashMap<Integer, String> readXML(String xmlFile, String tagName, String elementName) {

        HashMap<Integer, String> xmlHashMap = new HashMap<>();

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
            NodeList nodeElements = doc.getElementsByTagName(tagName); // "Race"
            for (int i = 0; i < nodeElements.getLength(); i++) {
                // getting the parent node
                Node node = nodeElements.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    System.out.println(eElement.getElementsByTagName(elementName).item(0).getTextContent()); // "RaceName"
                    xmlHashMap.put(i, eElement.getElementsByTagName(elementName).item(0).getTextContent());
                }
            }

        } catch (Exception e) {
            System.out.println("Exception at readXML(): " + e);
        }

        return xmlHashMap;
    }

}
