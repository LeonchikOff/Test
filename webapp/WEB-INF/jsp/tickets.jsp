<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tickets</title>
</head>
<body>
<%@include file="fragment/header.jsp" %>
<div>
    <h1>List of purchased tickets: </h1>
    <hr>

    <c:choose>
        <c:when test="${param.get('flightId') != null}">
            <c:choose>
                <c:when test="${not empty requestScope.tickets}">
                    <c:forEach items="${requestScope.tickets}" var="ticket">
                        <ul>
                            <li>
                                Flight Id: ${ticket.flightId}, Ticket Id: ${ticket.id}, Seat
                                Number: ${ticket.seatNumber}
                            </li>
                        </ul>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <span>No tickets purchased for this flight</span>
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <span>Specify the flight id</span>
        </c:otherwise>
    </c:choose>
    <hr>
</div>
<%@include file="fragment/footer.jsp" %>
</body>
</html>