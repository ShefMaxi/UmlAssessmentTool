package FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
 
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.StAXEventBuilder;
import org.jdom2.input.StAXStreamBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
 
//import com.journaldev.xml.Employee;
 
 
public class XmiFileReader {
 
    public static void main(String[] args) {
        final String fileName = "Example.xmi";
        org.jdom2.Document jdomDoc;
        try {
            //we can create JDOM Document from DOM, SAX and STAX Parser Builder classes
            jdomDoc = useDOMParser(fileName);
            Element root = jdomDoc.getRootElement();
            List<Element> empListElements = root.getChildren("packagedElement");
          //  List<Element> empListElements1 = root.getChildren("eAnnotations");
            List<ActorsXmi> empList = new ArrayList<>();
            for (Element empElement : empListElements) {
            	ActorsXmi emp = new ActorsXmi();
                emp.setId(empElement.getAttributeValue("id"));
               // emp.setAge(Integer.parseInt(empElement.getChildText("age")));
                emp.setName(empElement.getAttributeValue("name"));
              //  emp.setRole(empElement.getChildText("role"));
                emp.setType(empElement.getAttributeValue("type"));
                empList.add(emp);
               
            }
            //lets print Employees list information
            for (ActorsXmi emp : empList)
                System.out.println(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
 
    //Get JDOM document from DOM Parser
    private static org.jdom2.Document useDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        //creating DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();
        return domBuilder.build(doc);
 
    }
}