<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flights</title>
</head>
<body>
<%@include file="fragment/header.jsp" %>
<div>
    <h1>List of flights: </h1>
    <hr>
    <ul>
    <c:forEach var="flight" items="${requestScope.flights}">
            <li><a href="${pageContext.request.contextPath}/tickets?flightId=${flight.id}">${flight.description}</a></li>
    </c:forEach>
    </ul>
    <hr>
</div>
<%@include file="fragment/footer.jsp" %>
</body>
</html>
