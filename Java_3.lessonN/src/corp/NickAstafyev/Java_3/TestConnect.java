package corp.NickAstafyev.Java_3;

import java.sql.*;

/**
 * Created by Nick Astafyev
 */

public class TestConnect {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement ps;


    // Установка соединения
    protected static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:TEST.db");
        stmt = connection.createStatement();
    }

    // Разъединение
    protected static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Подготовленный запрос
    protected static void psCon(int n) throws SQLException {//Подготовленный запрос

        ps = connection.prepareStatement("INSERT INTO TEST (FIELD) VALUES (?);");
        long t = System.currentTimeMillis();
        connection.setAutoCommit(false);

        for (int i = 1; i <= n; i++) {

            ps.setInt(1, i);
//            ps.executeUpdate();
            ps.addBatch();
        }
        ps.executeBatch();
        connection.commit();

        System.out.print("время БД: ");
        System.out.println(System.currentTimeMillis() - t);
    }

    // удаление таблицы
    protected static void dropTableEx() throws SQLException {
        stmt.execute("DROP TABLE IF EXISTS TEST");
    }

    // Создание таблицы
    protected static void createTableEx() throws SQLException {
        stmt.execute("CREATE TABLE TEST (\n" +
                "        FIELD INTEGER\n" +
                ");");
    }

}
