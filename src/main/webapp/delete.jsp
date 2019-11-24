<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
    <div>
        <%
            if (request.getAttribute("user") != null) {
                out.println("<p>User " + request.getAttribute("name") + " " + request.getAttribute("surName") + " is delete.</p>");
            }
        %>
    </div>
    <form action="allUsers" method="get">
        <button type="submit">Back to main menu</button>
    </form>
</body>
</html>