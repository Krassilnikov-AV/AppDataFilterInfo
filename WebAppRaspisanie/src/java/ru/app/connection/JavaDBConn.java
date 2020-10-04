package ru.app.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import ru.app.doc.ReadExcelData;

public class JavaDBConn {

    private static Connection conn = null;
    private static String URL = "jdbc:postgresql://localhost:5432/test";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "alex159";

    public static void main(String[] args) throws SQLException {

        PreparedStatement stm = null;
        ResultSet result = null;

        String SQL = "insert into contact(value) values (?)";

        try {
            System.out.println("Устанавливаем соединение с БД...");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            /**
             * String sql = "insert into student_group (student_id, group_id)
             * values (?, ?)"; //Connection connection = new getConnection();
             * PreparedStatement ps = connection.prepareStatement(sql); String
             * student_id = "Какойто_ид_студента"; ArrayList<String> groups = //
             * это твой лист с группами
             *
             * for (Student group : groups) { ps.setString(1, student_id);
             * ps.setString(2, group); ps.addBatch(); } ps.executeBatch();
             * ps.close(); connection.close();
             */
// вставку данных в столбец, запрос: INSERT INTO таблица(поле1, поле2) VALUES (значение1, значение2)

            stm = conn.prepareStatement(SQL);

            ReadExcelData red = new ReadExcelData();
            List<String> list = red.extractExcelContentByColumnIndex(0);

            for (String value : list) {
                stm.setString(1, value);
                stm.addBatch();
                stm.executeUpdate();
            }

            //     запрос просмотра данных в столбце
            SQL = "SELECT value FROM \"public\".contact LIMIT 100000;";
            stm = conn.prepareStatement(SQL);
            result = stm.executeQuery();

            while (result.next()) {
                String value = result.getString("value");
                System.out.println(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            System.out.println("Закрыли соединение с БД после внесения и просмотра данных...");
        }
    }
}
