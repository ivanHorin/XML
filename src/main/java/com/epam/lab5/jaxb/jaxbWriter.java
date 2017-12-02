package com.epam.lab5.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class jaxbWriter {
    public static void main(String[] args) throws JAXBException {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Ivan");
        customer.setLastName("Horin");

        xmlJaxbWriter("JAXB/customer.xml", customer);
    }

    public static <T> void xmlJaxbWriter(String pathName, T objectToMarshall) throws JAXBException {

        File file = new File(pathName);
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(objectToMarshall, file);

        System.out.println("Xml file content:\n");
        marshaller.marshal(objectToMarshall, System.out);

    }
}
