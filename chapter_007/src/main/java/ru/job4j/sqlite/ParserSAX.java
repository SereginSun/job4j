package ru.job4j.sqlite;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * class ParserSAX
 * Parsing XML file.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 21.12.2019
 */
public class ParserSAX extends DefaultHandler {
    private int sum;

    /**
     * A method that parses a converted xml file.
     *
     * @param file - XML file for parsing.
     * @return the sum of the values of all the "field" attributes.
     */
    public int parseFile(File file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        Handler handler = new Handler();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
            parser.parse(new File(file.getPath()), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.sum;
    }

    private class Handler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("entry")) {
                String value = attributes.getValue("field");
                sum += Integer.parseInt(value);
            }
        }
    }
}
