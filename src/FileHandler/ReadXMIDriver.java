package FileHandler;
import java.io.File;
//import java.io.I0Exception;
import java.util.Iterator;
import  java.util.List;
import  org.jdom2.Document;
import  org.jdom2.Element;
import  org.jdom2.JDOMException;
import  org.jdom2.input.SAXBuilder;

//
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
import org.xml.sax.SAXException;



public class ReadXMIDriver {
	public static void main(String[] args) {
		
	}
	
	public static void readXMIFile() throws JDOMException, IOException {
		
		//Element packagedElement = ((Document) (new SAXBuilder()).build(new File("project11.xmi"))).getRootElement();
		
		
		
		
		
		Element type = null;
		//Element id = null;
		Element name = null;
		Element packagedElement = ((Document) (new SAXBuilder()).build(new File("aaa.xml"))).getRootElement();
		List<Element> packagedList = packagedElement.getChildren("note");
		for (int i=0; i<packagedList.size(); i++)
		{
			type = (Element) packagedList.get(i);
			Iterator<Element> nameIterator = type.getChildren("from").iterator();
			while(nameIterator.hasNext()){
				name =(Element) nameIterator.next();
			}
			System.out.print(name.getName()+ name.getChildText("from"));
		}
	}
}


























/*
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
 
 
public class ReadXMLDriver {
 
    public static void main(String[] args) {
        final String fileName = "C:/Users/Dell/Desktop/heoeoeoeo_2/employees.xml";
        org.jdom2.Document jdomDoc;
        try {
            //we can create JDOM Document from DOM, SAX and STAX Parser Builder classes
            jdomDoc = useDOMParser(fileName);
            Element root = jdomDoc.getRootElement();
            List<Element> empListElements = root.getChildren("Employee");
            List<Employee> empList = new ArrayList<>();
            for (Element empElement : empListElements) {
                Employee emp = new Employee();
                emp.setId(Integer.parseInt(empElement.getAttributeValue("id")));
                emp.setAge(Integer.parseInt(empElement.getChildText("age")));
                emp.setName(empElement.getChildText("name"));
                emp.setRole(empElement.getChildText("role"));
                emp.setGender(empElement.getChildText("gender"));
                empList.add(emp);
            }
            //lets print Employees list information
            for (Employee emp : empList)
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
}*/