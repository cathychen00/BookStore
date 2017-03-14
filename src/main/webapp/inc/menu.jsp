<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈敬
  Date: 2017/3/13
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <c:if test="${not empty currentUser}">
        欢迎您 ${currentUser.name}
    </c:if>
    <ul>
        <c:if test="${empty currentUser}">
            <li><a href="login.jsp">登录</a></li>
            <li>注册</li>
        </c:if>

        <c:if test="${not empty currentUser and currentUser.admin}">
            <%--<li>--%>
                <%--<a href="admin/bookList.action">查看图书</a>--%>
            <%--</li>--%>
            <li>
                <a href="/admin/BookAdd.jsp">添加图书</a>
            </li>
            <%--<li>--%>
                <%--<a href="admin/storageList.action">查看库存</a>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<a href="admin/storageAdd.action">图书入库</a>--%>
            <%--</li>--%>
        </c:if>
    </ul>
</div>