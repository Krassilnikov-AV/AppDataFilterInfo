<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Поиск папок и файлов</title>
        <style>
            body {
                background-color:#AFA;
            }
            #box {
                position: absolute;
                top: 20%;
                left: 50%;
                margin: -90px 0 0 -250px;
                width: 350px;
                height: 1000px;
                border: outset 1px green;
                background-color: #AAA;
                padding:5px;               
            }
            table {
                width: 100%;
                height: 100%;
                border: solid red 1px;
            }
            <!-- центрирование текста в полях и кнопках -->      
            td {
                text-align: left;              
            }
        </style>
    </head>
    <body>
        <div id="box">           
            <h1>Enter a query</h1>
            <form action="RESTFfullServlet" method="Get">
                <table>
                    <tr>
                        Директория:&nbsp;
                    <input type="text" name="direct" size="15" /><Br>
                    <input type="submit" name="direct" value="Директория"  /><Br>
                    Папка/Файл:&nbsp;
                    <input type="text" name="file" size="15" /><Br>
                    <td><input type="submit" name="sfile" value="Папка/Файл"  /> </td>
                    </tr>
                </table>
            </form>

            <% String result = (String) request.getAttribute("result");
                if (result != null) {
                    out.println("<h2>" + result + "</h2>");
                }
            %>
    </body>
</html>