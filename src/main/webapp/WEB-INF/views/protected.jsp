<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Protected page</title>
</head>
<body>
<header>
    <h1>Заголовок: ${title}</h1>
</header>
<section>
    <h1>Сообщение: ${message}</h1>
</section>
<c:if test="${pageContext.request.userPrincipal.name != null}">
<h2>Welcome : ${pageContext.request.userPrincipal.name}
    | <c:url value="login?logout" var="logoutUrl"/>
    <a href="${logoutUrl}">Log Out</a>
    </c:if>
</h2>
<ul>
    <li>Раздел сайта <a href="protected">protected</a> - для администраторов (Логин: admin / пароль: admin).</li>
    <li>Раздел сайта <a href="confidential">confidential</a> - для супер-администраторов (superadmin).</li>
</ul>
<footer>
    <div>Пример Spring Security Hello World Config</div>
</footer>
</body>
</html>