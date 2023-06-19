package ParseXML;

import java.io.StringReader;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ParseXMLAllSeasons extends ParseXML {

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

            // get the first element
            Element elem = doc.getDocumentElement();

            // get all child nodes
            NodeList nodes = elem.getChildNodes();

            // print the text of each child node
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println(nodes.item(i).getTextContent());
            }

        } catch (Exception e) {
            System.out.println("Exception at readXML(): " + e);
        }

        return xmlHashMap;
    }

}
