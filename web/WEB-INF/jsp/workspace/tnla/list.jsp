<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <!DOCTYPE html>
<html lang="ru">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ТНПА</title>
  <style>
    <%@include file="/WEB-INF/css/style.css"%>
  </style>
</head>

<body>
  <div class="container">

    <header class="header">
      <a href="index.html" class="logo">
        <img src="images/logoCable.svg" alt="Logotype" class="logo">
      </a>
      <div class="authentication">
        <form action="user-input.html" class="authentication-form">
          <div class="authentication-form-fieldset">
            <h3>Винокуров К.А.</h3>
          </div>
          <div class="authentication-form-href">
            <p><a href="output.html">Выход</a></p>
          </div>
        </form>
      </div>
    </header>

    <div class="menu">
      <div class="menu-hrefs">
        <div class="menu-href">
          <a href="TNLA.html" class="menu-href TNLA">ТНПА</a>
        </div>
        <div class="menu-href">
          <a href="parameters.html" class="menu-href">Параметры</a>
        </div>
        <div class="menu-href">
          <a href="formuls.html" class="menu-href">Формулы</a>
        </div>
        <div class="menu-href">
          <a href="raw_materials.html" class="menu-href">Сырьё</a>
        </div>
      </div>
    </div>

    <div class="container-main">
      <div class="left_pannel">
        <form action="AU_TNLA.html" class="left_pannel-search">
          <button class="button left_pannel-button button_add">
            <span class="button-text">Добавить</span>
          </button>
        </form>
        <form action="AU_TNLA.html" class="left_pannel-search">
          <button class="button left_pannel-button button_update">
            <span class="button-text">Изменить</span>
          </button>
        </form>
        <form action="tablesTNLA.html" class="left_pannel-search">
          <button class="button left_pannel-button button_tables">
            <span class="button-text">Таблицы</span>
          </button>
        </form>
      </div>
      <div class="main main-workspace">
        <table>
          <tr>
            <th>id</th>
            <th>Код ТНПА</th>
            <th>Наименование ТНПА</th>
            <th>Дата от</th>
            <th>Дата до</th>
          </tr>
			<c:forEach var="tnla" items="${tnlas}">
			<tr>
				<td><input name="tableTNLA" type="radio" value="tableTNLA"></td>
				<td>${tnla.codTnla}</td>
				<td>${tnla.nameTnla}</td>
				<td>${tnla.dateStartTnla}"</td>
				<td>${tnla.dateEndTnla}"</td>
			</tr>
			</c:forEach>
		</table>
      </div>
    </div>
  </div>
</body>

</html>