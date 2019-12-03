<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
    <div>
        <%
                out.println("<p>Welcome to your page " + request.getAttribute("name") + "!</p>");
        %>
        <%
            if (session.getAttribute("role").equals("admin")) {
                %>
        <form action="admin/allUsers" method="get">
            <button type="submit">To all users</button>
        </form>
                <%
                    } else {
                %>
        <form action="index" method="get">
            <button type="submit">Logout</button>
        </form>
        <%
            }
        %>
    </div>
</body>
</html>
