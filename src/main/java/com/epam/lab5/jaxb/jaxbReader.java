package com.epam.lab5.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class jaxbReader {
    public static void main(String[] args) throws JAXBException {
        File file = new File("JAXB/customer.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Customer customer = (Customer) unmarshaller.unmarshal(file);
        System.out.format("Customer id : %s\nName : %s\nLast Name: %s\n",
                customer.getId(), customer.getFirstName(), customer.getLastName());
    }
}
