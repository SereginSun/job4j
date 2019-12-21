package ru.job4j.sqlite;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * class ConvertXSLT
 * Converting an XML file received from StoreXML into a file of another XML format via XSLT.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 21.12.2019
 */
public class ConvertXSLT {

    /**
     * The method converts the incoming file in accordance with the specified scheme.
     * @param source - Input file.
     * @param dest - The file with the converted data.
     * @param scheme - Conversion scheme.
     */
    public void convert(File source, File dest, File scheme) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(scheme));
            transformer.transform(new StreamSource(source), new StreamResult(dest));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
