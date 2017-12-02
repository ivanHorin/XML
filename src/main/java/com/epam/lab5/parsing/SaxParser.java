package com.epam.lab5.parsing;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {

    public static void main(String[] args) {
        parseXML();
    }

    public static void parseXML() {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bname = false;
                boolean bgenre = false;
                boolean byear = false;

                public void startElement(String uri, String localName,
                                         String qName, Attributes attributes)
                        throws SAXException {

                    System.out.format("Start Element : %s\n", qName);

                    if (qName.equals("name")) {
                        bname = true;
                    }

                    if (qName.equals("genre")) {
                        bgenre = true;
                    }

                    if (qName.equals("year")) {
                        byear = true;
                    }
                }

                public void endElement(String uri, String localName,
                                       String qName)
                        throws SAXException {
                    System.out.format("End Element : %s\n", qName);
                }

                public void characters(char ch[], int start, int length)
                        throws SAXException {

                    if (bname) {
                        System.out.format("Name : %s\n", new String(ch, start, length));
                        bname = false;
                    }

                    if (bgenre) {
                        System.out.format("Genre : %s\n", new String(ch, start, length));
                        bgenre = false;
                    }

                    if (byear) {
                        System.out.format("Year : %s\n", new String(ch, start, length));
                        byear = false;
                    }
                }
            };

            saxParser.parse("movie.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

