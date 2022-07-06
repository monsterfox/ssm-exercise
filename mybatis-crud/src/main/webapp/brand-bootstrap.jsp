<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/7/5
  Time: 9:38
  原始方法：MyBatis和Jsp+BootStrap5的整合
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>品牌列表</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <h2 class="text-center">品牌列表</h2>
    <form class="bg-info my-3 p-3">
        <div class="row">
            <div class="col-6">
                <label for="comment">请输入评论：</label>
                <select class="btn btn-primary dropdown-toggle" id="comment" name="comment">
                    <option>当前状态</option>
                    <option>企业名称</option>
                    <option>品牌名称</option>
                </select>
                <input type="text" placeholder="" name="keywords">
            </div>
            <div class="col-6 pl-1">
                <button type="submit" class="btn btn-primary">搜索</button>
                <button type="reset" class="btn">重置</button>
            </div>
        </div>
    </form>
    <button type="button" class="btn btn-primary">+ 新增</button>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>编号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>当前状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${brands}" var="brand">
            <tr>
                <td>${brand.id}</td>
                <td>${brand.brandName}</td>
                <td>${brand.companyName}</td>
                <td>${brand.ordered}</td>
                <td>${brand.status}</td>
                <td><a href="#">修改</a> <a href="#">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
