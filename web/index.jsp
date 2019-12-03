<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main page</title>
  </head>
  <body>
    <form action="index" method="post">
      <label>
        Login: <input type="text" name="login" required>
      </label><br>
      <label>
        Password: <input type="password" name="password" required>
      </label><br>
        <button type="submit">Sing in</button>
    </form>
  </body>
</html>
