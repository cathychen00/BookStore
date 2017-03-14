<%--
  Created by IntelliJ IDEA.
  User: 陈敬
  Date: 2017/3/14
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>
</head>
<body>
<jsp:include page="/inc/menu.jsp"></jsp:include>
<div>
    <form method="post" action="/admin/bookAdd.action">
        <p>
            <label for="id-name">
                书名
            </label>
            <input type="text" id="id-name" name="name" />
        </p>
        <p>
            <label for="id-author">
                作者
            </label>
            <input type="text" id="id-author" name="author" />
        </p>
        <p>
            <label for="id-publisher">
                出版社
            </label>
            <input type="text" id="id-publisher" name="publisher" />
        </p>
        <p>
            <label for="id-price">
                价格
            </label>
            <input type="text" id="id-price" name="price" />
        </p>
        <input type="submit" class="submit" value="保存">
    </form>
</div>
</body>
</html>
