<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>MVC pet project</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
</head>
    <body>
    <div class="wrapper">
        <h1>Welcome!</h1>
        <h1>
        <a href="<c:url value="/employees"/>">To the employees list</a>
        </h1>
    </div>
    </body>
</html>