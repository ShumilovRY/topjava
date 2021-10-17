<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <title>Meals</title>
  <style>
    .normal {
      color: green;
    }
    .excess {
      color: red;
    }
  </style>
</head>
<body>
<h2>MealsWithExceed</h2>
<table border=1>
  <thead>
  <tr>
    <th>dateTime</th>
    <th>description</th>
    <th>calories</th>
  </tr>
  </thead>
  <tbody>
  <jsp:useBean id="meals" scope="request" type="java.util.List"/>
  <c:forEach items="${meals}" var="meals">
    <tr class="${meals.excess ? 'excess' : 'normal'}">
      <td>
        <fmt:parseDate value="${ meals.dateTime }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime"
                       type="both"/>
        <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${ parsedDateTime }"/>
      </td>
      <td><c:out value="${meals.description}"/></td>
      <td><c:out value="${meals.calories}"/></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<p><a href="./">Home</a></p>
</body>
</html>