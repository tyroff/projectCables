<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="ru">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>добавить ТНПА</title>
  <style>
    <%@include file="/WEB-INF/css/style.css"%>
  </style>
</head> 

<body>
  <div class="container">
    <header class="header">
		<jsp:include page="/prototypes/logo.html"/>
      <div class="authentication">
		<jsp:include page="/prototypes/authentication_workspace.html"/>
      </div>
    </header>

    <div class="menu"></div>

    <div class="container-main">
      <div class="left_pannel"></div>
      <div class="main main-workspace">
                <div class="au_form">
          <div class="head_au_form">
            <h1>Добавить ТНПА</h1>
          </div>
          <div class="main_au_form">
            <form action="AU-TNLAs">
              <fieldset title="код ТНПА" class="AU_fieldset">
                <legend>код ТНПА</legend>
                <input type="text" name="cod_TNLA">
              </fieldset>
              <fieldset title="наименование ТНПА" class="AU_fieldset">
                <legend>наименование ТНПА</legend>
                <input type="text" name="name_TNLA">
              </fieldset>
              <p class="au_text">Срок действия</p>
              <div class="data_TNLA">
                <fieldset title="дата от">
                  <legend>дата от</legend>
                  <input type="date" id="date" name="date_start">
                </fieldset>
                <fieldset title="дата до">
                  <legend>дата до</legend>
                  <input type="date" id="date" name="date_end">
                </fieldset>
                <div><input name="categoryTnla" type="radio" value="tableTNLA">
                	<p>Силовые кабели на напряжение 0,66-6 кВ</p>
                </div>
                <div><input name="categoryTnla" type="radio" value="tableTNLA">
                	<p>Провода бытового назначения</p>
                </div>
                <div><input name="categoryTnla" type="radio" value="tableTNLA">
                	<p>Кабели контрольные</p>
                </div>
                
              </div>
              <button class="button button_AU_form button_add">
                <span class="button-text">Сохранить</span>
              </button>
            </form>
            <button class="button button_AU_form">
              <span class="button-text">Отмена</span>
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>