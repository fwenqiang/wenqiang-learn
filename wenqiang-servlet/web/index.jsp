<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/4
  Time: 6:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="servlet/userServlet">
       用户名:<input name="userName" id="userName" type="text"><br>
       密&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" id="password"><br>
       <input type="submit" name="submit" value="提交">
  </form>
  </body>
</html>
