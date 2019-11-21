<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
    <div>
        <h1>Please enter parameters</h1>
    </div>
    <div>
        <form action="/addUser" method="post">
            Name: <input type="text" name="name"><br>
            Surname: <input type="text" name="surName"><br>
            Age: <input type="number" name="age"><br>
            <button type="submit">Submit</button>
        </form>
    </div>
    <div>
        <button onclick="location.href='/allUsers'">Back to main</button>
    </div>
</body>
</html>
