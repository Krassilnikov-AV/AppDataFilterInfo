<%-- 
    Document   : insertData
    Created on : 19.09.2020, 14:29:27
    Author     : Aleks
--%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<% Class.forName("org.postgresql.Driver");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // добавлениее русского алфавита в БД.
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>InsertData</title>
    </head>
    <body>
        <h1>Inserting Data Into a DB / Вставка данных в БД</h1>
        <%!
            public class Actor {

                String URL = "jdbc:postgresql://localhost:5432/sakila";
                String USERNAME = "postgres";
                String PASSWORD = "alex159";

                Connection conn = null;
                PreparedStatement insertData = null;
                ResultSet resSet = null;

                public Actor() {

                    try {
                        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                        insertData = conn.prepareStatement(
                                "INSERT INTO actor (first_name, last_name, last_update)" + " VALUES (?, ?, ?)");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                public int setActors(String first, String last, Timestamp timeStamp) {
                    int result = 0;
                    try {
                        insertData.setString(1, first);
                        insertData.setString(2, last);
                        insertData.setTimestamp(3, timeStamp);
                        result = insertData.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return result;
                }
            }
        %>
        <%
            int result = 0;

            //     if (request.getParameter("submit") != null) {
            String firstName = new String();
            String lastName = new String();

            if (request.getParameter("first") != null) {
                firstName = request.getParameter("first");
            }
            if (request.getParameter("last") != null) {
                lastName = request.getParameter("last");
            }

            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());

            Actor actor = new Actor();
            result = actor.setActors(firstName, lastName, timeStamp);
            //     }
        %>
        <form name="myForm" action="insertData.jsp" method="POST">
            <table border="0">               
                <tbody>
                    <tr>
                        <td>First Name: </td>
                        <td><input type="text" name="first" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Last Name: </td>
                        <td><input type="text" name="last" value="" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="reset" value="Clear" name="clear" />
            <input type="submit" value="Submit" name="submit" />   
        </form>
    </body>
</html>
