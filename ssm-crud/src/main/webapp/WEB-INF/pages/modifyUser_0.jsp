<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/7/22
  Time: 14:03
  To change tdis template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加用户</title>
    <!-- 新 Bootstrap5 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css">
    <!--  popper.min.js 用于弹窗、提示、下拉菜单 -->
    <script src="https://cdn.staticfile.org/popper.js/2.9.3/umd/popper.min.js"></script>
    <!-- 最新的 Bootstrap5 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <h2 class="text-center">修改用户</h2>
    <form action="doModifyUser.do" method="post">
    <table class="table table-bordered w-50 mx-auto">
        <input type="hidden" name="id" value="${user.id}" />
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="${user.username}" /></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><input type="text" name="sex" value="${user.sex}" /></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="number" name="age" value="${user.age}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="修改" class="btn btn-primary" />
                <input type="reset" value="取消" class="btn btn-light" />
            </td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>
