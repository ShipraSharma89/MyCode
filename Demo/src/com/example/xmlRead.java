package com.example;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class xmlRead {
	public static void main(String argv[]) {
	    try {
	    File fXmlFile = new File("test-data\\testng-results.xml");
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(fXmlFile);
	    doc.getDocumentElement().normalize();

	    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	    NodeList nList = doc.getElementsByTagName("class");
	    for (int temp = 0; temp < nList.getLength(); temp++) {
	        Node nNode = nList.item(temp);
	        System.out.println("\nCurrent Element :" + nNode.getNodeName());
	        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            Element eElement = (Element) nNode;
	            System.out.println("Test method : "
                        + eElement.getElementsByTagName("test-method").item(0).getTextContent());

	        }
	    }
	} catch (Exception e) {
	    e.printStackTrace();
}
	}
}


