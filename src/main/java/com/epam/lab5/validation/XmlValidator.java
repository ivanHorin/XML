package com.epam.lab5.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {

    public static void main(String[] args) {

        if(validate("movie.xml","movie.xsd"))
            System.out.println("Validation is SUCCESSFUL");
        else System.out.println("Validation is FAILED");

    }

    public static boolean validate(String xmlFileName, String xsdFileName){
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new StreamSource(new File(xsdFileName)));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFileName)));
            return true;
        } catch (SAXException |IOException e) {
            return false;
        }
    }

}
