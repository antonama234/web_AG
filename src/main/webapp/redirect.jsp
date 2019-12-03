<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Only for Administrator</title>
</head>
<body>
    <%
        out.println("<p>Administrator rights are required!<p>");
    %>
    <form action="${pageContext.request.contextPath}/user" method="get">
        <button type="submit">Back to your page</button>
    </form>
</body>
</html>
