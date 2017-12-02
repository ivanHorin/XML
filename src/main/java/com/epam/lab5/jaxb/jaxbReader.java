package com.epam.lab5.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class jaxbReader {
    public static void main(String[] args) throws JAXBException {

        Customer customer=xmlJaxbReader("JAXB/customer.xml");
        System.out.format("Customer id : %s\nName : %s\nLast Name: %s\n",
                customer.getId(), customer.getFirstName(), customer.getLastName());
    }

    public static<T> T xmlJaxbReader(String pathName) throws JAXBException {
        File file = new File(pathName);
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        T unmarshalledObject = (T) unmarshaller.unmarshal(file);
        return unmarshalledObject;
    }
}
