package ParseXML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.StringReader;
import java.util.HashMap;

/**
 * The default XML parser for the responses from the ergast API
 */
public abstract class ParseXML {

    /**
     * 
     * @param xmlFile     is the raw file that is returned from ergast API as a
     *                    string
     * @param tagName     is parent tag based on the data requst (race, qualifying,
     *                    etc.)
     * @param elementName is the child tag that has the text content (first name,
     *                    last name, etc.)
     * @return a hashmap of the index as the key and elmentName as the value
     */
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

            // ordered collection of nodes
            NodeList nodeElements = doc.getElementsByTagName(tagName); // "Race"
            for (int i = 0; i < nodeElements.getLength(); i++) {
                // getting the parent node
                Node node = nodeElements.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    System.out.println(
                            (i + 1) + "\t" + eElement.getElementsByTagName(elementName).item(0).getTextContent()); // "RaceName"
                    xmlHashMap.put(i, eElement.getElementsByTagName(elementName).item(0).getTextContent());
                }
            }

        } catch (Exception e) {
            System.out.println("Exception at readXML(): " + e);
        }

        return xmlHashMap;
    }

}
