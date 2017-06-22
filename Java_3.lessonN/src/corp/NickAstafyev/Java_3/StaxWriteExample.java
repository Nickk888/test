package corp.NickAstafyev.Java_3;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;


/**
 * Created by Nick Astafyev
 */

public class StaxWriteExample {

    private static Connection connection;
    private static Statement stmt;

    public static void mn() {

        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter("1.xml"));

            // Открываем XML-документ и Пишем корневой элемент
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("entries");
            // Делаем цикл
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:TEST.db");
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TEST");

            while (rs.next()) {

                writer.writeStartElement("entry");
                // Заполняем все тэги
                writer.writeStartElement("field");
                writer.writeCharacters(rs.getString("FIELD"));//передает значение
                writer.writeEndElement();
                // Закрываем тэг entry
                writer.writeEndElement();
                // field
            }

            // Закрываем корневой элемент entries
            writer.writeEndElement();
            // Закрываем XML-документ
            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException | IOException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
