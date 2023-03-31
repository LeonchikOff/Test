<%--<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <p>JSESSIONID: ${cookie["JSESSIONID"].value}</p>
    <hr>
    <span>Content: контент</span>
    <c:set var="totalNumberFlights" value="${requestScope.flights.size()}"/>
    <p>Total number of flights: ${totalNumberFlights}</p>
    <c:forEach items="${requestScope.flights}" var="flight">
        <p>Flight ID ${flight.id}: Flight Description ${flight.description}</p>
    </c:forEach>
</div>
