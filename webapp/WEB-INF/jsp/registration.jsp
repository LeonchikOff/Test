<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/images/avatars/U3DqjLhrNNc.jpg" alt="User avatar">
<form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
    <label>
        Avatar: <input type="file" name="avatar" id="avatar">
    </label><br>
    <label for="username">
        Name: <input type="text" name="username" id="username">
    </label><br>
    <label for="birthDate">
        Birth date: <input type="date" name="birthDate" id="birthDate">
    </label><br>
    <label for="email">
        Email: <input type="text" name="email" id="email">
    </label><br>
    <label for="password">
        Password: <input type="password" name="password" id="password">
    </label><br>
    <label for="role">
        Role: <select name="role" id="role">
        <c:forEach items="${requestScope.roles}" var="role">
            <option value="${role}">${role}</option>
        </c:forEach>
    </select>
    </label><br>
    <label>
        <c:forEach items="${requestScope.genders}" var="gender">
            ${gender}: <input type="radio" name="gender" value="${gender}">
        </c:forEach>
    </label><br>
    <button type="submit">Registration</button>
    <div style="color: red">
        <c:if test="${not empty requestScope.constraints}">
            <c:forEach var="constraint" items="${requestScope.constraints}">
                <span>Constraint: ${constraint.massage}</span><br>
            </c:forEach>
        </c:if>
    </div>
</form>
</body>
</html>
