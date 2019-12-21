package ru.job4j.sqlite;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

/**
 * class StoreXML
 * Generates XML file from database.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 21.12.2019
 */
public class StoreXML {
    private File target;

    public StoreXML(File target) {
        this.target = target;
    }

    /**
     * The method saves the data received from the database into an XML file.
     * @param list - List of Entry objects with field values obtained from the database field column.
     */
    public void save(List<Entry> list) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(new Entries(list), target);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
