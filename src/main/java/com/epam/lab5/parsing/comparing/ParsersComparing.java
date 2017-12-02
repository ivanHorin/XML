package com.epam.lab5.parsing.comparing;

import com.epam.lab5.parsing.DomParser;
import com.epam.lab5.parsing.SaxParser;
import com.epam.lab5.parsing.StaxParser;

public class ParsersComparing {

    public static void main(String[] args) {
        long startTime;

        System.out.println("\n-------DOM parser result:--------\n");
        startTime = System.currentTimeMillis();
        DomParser.parseXML();
        String domParserElapsedTime = TimeCounting.elapsedTimeAmount(startTime);

        System.out.println("\n-------SAX parser result:--------\n");
        startTime = System.currentTimeMillis();
        SaxParser.parseXML();
        String saxParserElapsedTime = TimeCounting.elapsedTimeAmount(startTime);

        System.out.println("\n-------StAX parser result:--------\n");
        startTime = System.currentTimeMillis();
        StaxParser.parseXML();
        String staxParserElapsedTime = TimeCounting.elapsedTimeAmount(startTime);

        System.out.format("DOM Parser %s\n", domParserElapsedTime);
        System.out.format("SAX Parser %s\n", saxParserElapsedTime);
        System.out.format("StAX Parser %s\n", staxParserElapsedTime);

        /*The fastest parser is StAx.*/
    }
}
