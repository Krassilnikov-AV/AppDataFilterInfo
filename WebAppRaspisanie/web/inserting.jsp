<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // распознавание русского алфавита на JSP.
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Raspisanie</title>
</head>

<body>
    <h2>Создание отчётов</h2>
    <form name="myForm" action="inserting.jsp" method="POST">
        <table width="400" border="0" cellpadding="3" cellspacing="0">
            <col width="100" valign="top">
            <col width="250" valign="top">
            <tbody>
                <tr><td><b>Вид отчёта</b></td></tr>
<!--                <tr><td><input name="dzen" type="radio" value="nedzen"> Расписание</td></tr>
                <tr><td><input name="dzen" type="radio" value="dzen"> Внештатные сотрудники</td></tr>          -->
                <!---Другой вариант выбора отчета--->
                <tr><td>
                        <p><select  size="1" required>
                                <option disabled>Выберите вид отчёта</option>
                                <option value="Расписание">Расписание по курсу</option>
                                <option selected value="Внештатные сотрудники">Внештатные сотрудники</option>                              
                            </select></p>
                    </td></tr>
                <tr>
                    <td><input type="file" name="file" value="" width="50" /></td>
                </tr>               
                <tr><td>
                        <p>Поиск группы: <input type="text" name="last" value="" size="50" >
                            <input type="submit" value="Найти" name="submit" ></p>
                    </td></tr>
                <tr><td>
                        <p>Выберите месяц: <input type="month" name="calendar">
                            <input type="submit" value="Отправить"></p>
                        <p>Результаты поиска: </p>  
                    </td></tr>

                <tr>
                    <td><textarea name="filter" rows="15" cols="100"> </textarea></td>                
                </tr>
                <tr><td><p><input type="submit" value="Выбрать" name="submit" >
                            <input type="submit" value="Удалить" name="submit" >
                        </p></td></tr>
                <tr><td><p><input type="submit" value="Создать_отчёт"></p></td></tr>
                </form> 
            </tbody>
        </table>
    </form>
</body>