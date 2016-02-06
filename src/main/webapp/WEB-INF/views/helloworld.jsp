<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Начальная страница приложения</title>
</head>
<body>
<header>
    <h1>Заголовок: ${title}</h1>
</header>
<section>
    <h1>Сообщение: ${message}</h1>
</section>
<ul>
    <li>Раздел сайта <a href="protected">protected</a> - для администраторов (Логин: admin / пароль: admin).</li>
    <li>Раздел сайта <a href="confidential">confidential</a> - для супер-администраторов (superadmin).</li>
</ul>
<footer>
    <div>Пример Spring Security Hello World Config</div>
</footer>
</body>
</html>