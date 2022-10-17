<%@ page import="beans.Result" %><%--
  Created by IntelliJ IDEA.
  User: kristina
  Date: 2022-10-15
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="table" class="beans.TableDB" scope="session" />
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Лабораторная работа 2</title>
    <link rel="stylesheet" href="css/main.css">
</head>

<script src="https://code.jquery.com/jquery-1.12.3.min.js"
        integrity="sha256-aaODHAgvwQW1bFOGXMeX+pC4PZIPsvn2h1sArYOhgXQ="
        crossorigin="anonymous"></script>
<script src="js/requestSender.js"></script>
<script src="js/validator.js"></script>
<body onload="fillValues()">
<div class="container">
    <div class="header">
        <p class="title">Бернятцкая Кристина, P32081.<br>Вариант №231.<br></p>
        <p id="txt" class="title"></p>
    </div>
    <div class="content">
        <h2 id="header">Лабораторная работа №2</h2>
        <!--<img src="resource/areas.png" id = "graph" alt="График">-->
        <canvas id="graph" height="200" width="200"></canvas>
        <script src="js/drawer.js"></script>

        <p>Введите значения X, Y и R, чтобы узнать, попадет ли точка в синюю область на графике.</p>
        <p id="errorMessage"></p>
        <form name="OptionForm" id="OptionForm" method="GET" action="">
            <fieldset>
                <!-- x have to be checkbox-->
                <div class="labels">
                    <label for="X">X ∈ <b>[-5, 3]</b></label>
                    <select id="X" name="X">
                        <option value="-5">-5</option>
                        <option value="-4">-4</option>
                        <option value="-3">-3</option>
                        <option value="-2">-2</option>
                        <option value="-1">-1</option>
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select><br>
                    <label for="Y">Y ∈ <b>[-3, 3]</b></label>
                    <input type="text" maxlength="10" class="number" id="Y" name="Y"><br>
                    <label for="R">R ∈ <b>[1, 5]</b></label>
                    <select id="R" name="R">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select><br>
                </div>
                <input type="button" id="submit" value="Проверить">
            </fieldset>
        </form>
        <div id="results">
            <h3>Таблица результатов</h3>
            <button id="cleanButton" onclick="cleanTable()">Очистить</button>
            <table id="respTable">
                <tr>
                    <th id="testing">X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>Результат</th>
                    <th>Время работы скрипта</th>
                    <th>Дата и время</th>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>