<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<h1>Header: Заголовок</h1>
<c:if test="${not empty sessionScope.user}">
    <div>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>
</c:if>
