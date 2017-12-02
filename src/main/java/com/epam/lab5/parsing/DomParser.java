package com.epam.lab5.parsing;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

public class DomParser {

    public static void main(String[] args) {
        parseXML();
    }

    public static void parseXML() {
        try {
            File fXmlFile = new File("movie.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = (Document) documentBuilder.parse(fXmlFile);

            System.out.format("Root element :%s\n", document.getDocumentElement().getNodeName());
            NodeList movieList = document.getElementsByTagName("movie");

            for (int i = 0; i < movieList.getLength(); i++) {

                Node nNode = movieList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.format("Current element : %s\n", nNode.getNodeName());
                    System.out.format("Name : %s\n", getTagValue("name", eElement));
                    System.out.format("Genre : %s\n", getTagValue("genre", eElement));
                    System.out.format("Year : %s\n\n", getTagValue("year", eElement));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTagValue(String sTag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
    }
}

