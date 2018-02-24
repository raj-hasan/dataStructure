package datastructure;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Implement a function folderNames, which accepts a string containing an XML file that specifies folder structure and returns all folder names that start with startingLetter. The XML format is given in the example below.

 For example, for the letter 'u' and an XML file:

 <?xml version="1.0" encoding="UTF-8"?>
 <folder name="c">
 <folder name="program files">
 <folder name="uninstall information" />
 </folder>
 <folder name="users" />
 </folder>
 the function should return a collection with items "uninstall information" and "users" (in any order).
 */
public class Folder {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        org.w3c.dom.Document document = builder.parse(inputStream);
        NodeList nodeList = document.getElementsByTagName("folder");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            NamedNodeMap map = node.getAttributes();
            String folderName = map.getNamedItem("name").getNodeValue();
            //System.out.println(folderName);
            list.add(folderName);
        }
        Collection<String> collection = new ArrayList<String>();
        for(String s:list){
            if(s.startsWith(String.valueOf(startingLetter))){
                collection.add(s);
            }
        }
        return collection;
    }



    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}