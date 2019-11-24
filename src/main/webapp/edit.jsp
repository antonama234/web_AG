<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User edition</title>
</head>
<body>
    <h2>Enter new parameters:</h2>
    <form action="editUser" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td>Surname:</td>
                <td>Age:</td>
            </tr>
            <tr>
                <td><input type="text" name="newName" required></td>
                <td><input type="text" name="newSurName" required></td>
                <td><input type="number" name="newAge" required></td>
                <td><button type="submit">Submit</button></td>
            </tr>
        </table>
    </form>
    <form action="allUsers" method="get">
        <button type="submit">Back to main menu</button>
    </form>
</body>
</html>
