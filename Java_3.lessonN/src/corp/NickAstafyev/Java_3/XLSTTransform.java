package corp.NickAstafyev.Java_3;

import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;


public class XLSTTransform {
    public static void transform () {
        String xslPath = "mod.xsl";
        String xmlPath = "1.xml";
        try {
            TransformerFactory fact = new TransformerFactoryImpl();
            Transformer transformer = fact.newTransformer(new StreamSource(new File(xslPath)));
            transformer.transform(new StreamSource(new File(xmlPath)), new StreamResult(new File("2.xml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
