package corp.NickAstafyev.Java_3;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static javax.xml.bind.DatatypeConverter.parseInt;

/**
 * Created by Nick Astafyev
 */
public class Pars2xml {
    private static long sum = 0;
    public static void parsXmlSum() {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new File("2.xml")); // fileName - путь до xml
            Element root = document.getDocumentElement();

            NodeList list = root.getElementsByTagName("entry");
            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);
                sum += parseInt(element.getAttribute("field"));
            }

            System.out.print("сумма значений всех атрибутов field = ");
            System.out.println(sum);
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }

    }
}
