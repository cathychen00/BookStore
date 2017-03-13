<%--
  Created by IntelliJ IDEA.
  User: 陈敬
  Date: 2017/3/13
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login.action" method="post">
    <fieldset>
        <legend>
            登录
        </legend>
        <p>
            <label for='name'>
                登录名：
            </label>
            <input type='text' value='' name='name' id='name' />
        </p>
        <p>
            <label for="id-passwd">
                登录密码：
            </label>
            <input type="password" id="id-passwd" name="passwd" />
        </p>
        <p>
            <label>
                作为管理员
            </label>
            <label>
                <input type="checkbox" name="role" value="admin" />
            </label>
        </p>
        <input type="submit" class="submit" value="登录">
    </fieldset>
</form>
</body>
</html>
