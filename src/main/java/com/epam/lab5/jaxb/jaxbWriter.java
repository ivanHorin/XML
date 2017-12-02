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

        File file = new File("JAXB/customer.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, file);

        System.out.println("Xml file content:\n");
        marshaller.marshal(customer, System.out);
    }
}
