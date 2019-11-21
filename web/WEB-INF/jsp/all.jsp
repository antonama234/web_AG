<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>
    <h1>All users</h1>
    <table>
        <tr>
            <th>Number</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Age</th>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="users" items="${requestScope.allUsers}">
            <tr>
                <td>${users.id}</td>
                <td>${users.name}</td>
                <td>${users.sueName}</td>
                <td>${users.age}</td>
                <td>
                    <form method="post">
                        <button formaction="/editUser" name="id" value=${users.id}>Edit</button>
                    </form>
                    <form method="post">
                        <button formaction="/deleteUser" name="id" value=${users.id}>Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>