package com.epam.lab5.parsing;


import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StaxParser {

    public static void main(String[] args) {
        parseXML();
    }

    public static void parseXML() {
        boolean bFirstName = false;
        boolean bLastName = false;
        boolean bNickName = false;
        boolean bMarks = false;

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader("movie.xml"));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch (event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("movie")) {
                            System.out.println("Start Element : movie");
                        } else if (qName.equalsIgnoreCase("name")) {
                            bFirstName = true;
                        } else if (qName.equalsIgnoreCase("genre")) {
                            bLastName = true;
                        } else if (qName.equalsIgnoreCase("year")) {
                            bNickName = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if (bFirstName) {
                            System.out.println("Name: " + characters.getData());
                            bFirstName = false;
                        }
                        if (bLastName) {
                            System.out.println("Genre: " + characters.getData());
                            bLastName = false;
                        }
                        if (bNickName) {
                            System.out.println("Year: " + characters.getData());
                            bNickName = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if (endElement.getName().getLocalPart().equalsIgnoreCase("movie")) {
                            System.out.println("End Element : movie");
                            System.out.println();
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

    }
}


