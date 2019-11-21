<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User edition</title>
</head>
<body>
    <h2>Add new parameters:</h2>
    <form action="/editUser" method="post">
        Name: <input type="text" name="newName"><br>
        Surname: <input type="text" name="newSurName"><br>
        Age: <input type="text" name="newAge"><br>
        <button type="submit">Submit</button>
    </form>
    <div>
        <button onclick="location.href='/allUsers'">Back to main</button>
    </div>
</body>
</html>
