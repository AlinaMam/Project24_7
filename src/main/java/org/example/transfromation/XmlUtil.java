package org.example.transfromation;

import org.example.classesForUtil.XmlClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XmlUtil {
    private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class.getSimpleName());

    public static void createXMLstructure(XmlClass xmlClass) {
        try {
            JAXBContext context = JAXBContext.newInstance(XmlClass.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(xmlClass, new FileOutputStream("src/main/java/org/example/xmlReqs/req.xml"));
        } catch (JAXBException e) {
            logger.error("Error to create xml!");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            logger.error("File read error!");
            e.printStackTrace();
        }
    }
}
