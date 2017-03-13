<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page  isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: 陈敬
  Date: 2017/3/13
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@page isELIgnored="false" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    书籍列表
    <table>
        <c:forEach items="${storages}" var="s">
            <tr>
                <td>书名：</td>
                <td>${s.book.name}</td>
            </tr>
            <tr>
                <td>作者</td>
                <td>${s.book.author}</td>
            </tr>
            <tr>
                <td>
                    出版商
                </td>
                <td>
                        ${s.book.publisher }
                </td>
            </tr>
            <tr>
                <td>
                    价格
                </td>
                <td>
                        ${s.book.price }
                </td>
            </tr>
            <tr>
                <td>
                    数量
                </td>

                <td>
                        ${s.amount }
                </td>
            </tr>
            <tr>
                <td>
                    上架日期
                </td>
                <td>
                        ${s.inDate }
                </td>
            </tr>
            <tr><Td>操作</Td><td></td></tr>
            <%--<tr>--%>
            <%--<td colspan="2">--%>
            <%--<a href="common/bookView.action?id=${s.book.id }"--%>
            <%--style="text-decoration: none;"> 详细信息</a>--%>
            <%--<form action="common/bookToCart.action" method="post">--%>
            <%--数量：--%>
            <%--<input type="text" style="width: 30px;" name="amount" value="1">--%>
            <%--<input type="submit" value="放到购物车">--%>

            <%--<input type="hidden" name="bookName" value="${ s.book.name}">--%>
            <%--<input type="hidden" name="bookId" value="${ s.book.id}">--%>
            <%--</form>--%>
            <%--</td>--%>

            <%--</tr>--%>
        </c:forEach>
    </table>
</div>
</body>
</html>
