package FileHandler;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.DocumentParser;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;
//import com.
public class PrettyPrinter {
   public static void main(String[] args) {
        // Assume filename argument
       // String filename = args[0];
        try {
            // Build the document with SAX and Xerces, no validation
            SAXBuilder builder = new SAXBuilder();
            // Create the document
            org.jdom2.Document    jdomDoc;
         //   Document doc = builder.build(new File("project11.xmi"));
        jdomDoc= builder.build("project11.xmi");
        Element root = jdomDoc.getRootElement();
      //  Element Node=new Element ();
        DocumentParser parser=new DocumentParser(null);
        parser.parse("123");
        parser.parse("project11.xmi");
        Document doc=parser.getDocument();
        List<Element> childrenElement = root.getChildren();
        
		for (int i=0;i<childrenElement.size();i++)
		{
		System.out.println(childrenElement.get(i).getName());
		//System.out.println(root.addContent(childrenElement));
		
		}
		
		//System.out.println(childrenElement.toString());
		
		//printElement(childrenElement);
		//return childrenElement;
		root.
		
		
		
        //List<Element> packListElements = root.getChildren("PackagedElement");
       // Element PackagedElement = null;
       // List<PrettyPrinter> packagelist= new ArrayList<>();
        //for (Element empElement : packListElements) {
        //	packListElements.add(PackagedElement);
        	
       // }
       // for (Element Element : packListElements){
        	
       // }
         //   System.out.println(packListElements);
            System.out.println(root);
    	
            // Output the document, use standard formatter
            XMLOutputter fmt = new XMLOutputter();
            //fmt.output(doc, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
