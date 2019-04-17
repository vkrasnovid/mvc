<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employees Page</title>
    <link rel="stylesheet" href="/resources/css/style.css"
</head>
    <body>

    <div id="add">
    <c:url var="addAction" value="/employee/add"/>

    <br>
    <h3>Add a new employee</h3>
    <form:form action="${addAction}" modelAttribute="employee">
        <table>
            <c:if test="${!empty employee.name}">
                <tr>
                    <td>
                        <form:label path="id">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="id" readonly="true" size="8" disabled="true"/>
                        <form:hidden path="id"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="name">
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="age">
                        <spring:message text="Age"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="age"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty employee.name}">
                        <input type="submit"
                               value="<spring:message text="Save"/>"/>
                        <button onclick="window.location.href=window.location.href;">Cancel</button>
                    </c:if>
                    <c:if test="${empty employee.name}">
                        <input type="submit"
                               value="<spring:message text="Add Employee"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<h3 >Employees list</h3>

<div id="tab">
<table>
    <display:table border="1" id="employee" name="listEmployees" requestURI="" pagesize="10" >
        <display:column property="id" title="ID" sortable="true"/>
        <display:column property="name" title="Employee First Name" sortable="true"/>
        <display:column property="age" title="Employee Age" sortable="true"/>
        <display:column property="edit" title="Edit"/>
        <display:column property="delete" title="Delete"/>
    </display:table>
</table>
</div>
<br/>



<br>
<h3>Search</h3>
<br>

<form:form method="post" modelAttribute="employee" action="findEmployee">
    <form:label path="name">Name</form:label>
    <form:input path="name"/>
</form:form>

    <div id="back">
<br>
<a href="/">Back to main menu</a>
<br>
        </div>
    </body>
</html>
