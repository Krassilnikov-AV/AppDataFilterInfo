package sampleexampleinsertdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleExampleInsertDB {

    private static Connection conn = null;
    private static String URL = "jdbc:postgresql://localhost:5432/sakila";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "alex159";

    public static void main(String[] args) throws SQLException {

        Statement stm = null;
        ResultSet result = null;
        String value = "";
        String SQL = "";

        try {
            System.out.println("Устанавливаем соединение с БД...");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

// вставку данных в столбец, запрос: INSERT INTO таблица(поле1, поле2) VALUES (значение1, значение2)
            SQL = "INSERT INTO actor(first_name) VALUES ('Georg');";

            stm = conn.createStatement();
            stm.executeUpdate(SQL);

            // запрос просмотра данных в столбце
            SQL = "SELECT first_name FROM \"public\".actor LIMIT 100;";

            stm = conn.createStatement();
            result = stm.executeQuery(SQL);

            while (result.next()) {
                value = result.getString("first_name");
                System.out.println(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            System.out.println("Закрыли соединение с БД...");
        }
    }
}
