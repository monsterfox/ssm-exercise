<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/7/22
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表</title>
  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
  <!-- 新 Bootstrap5 核心 CSS 文件 -->
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/css/bootstrap.min.css">
  <!--  popper.min.js 用于弹窗、提示、下拉菜单 -->
  <script src="https://cdn.staticfile.org/popper.js/2.9.3/umd/popper.min.js"></script>
  <!-- 最新的 Bootstrap5 核心 JavaScript 文件 -->
  <script src="https://cdn.staticfile.org/twitter-bootstrap/5.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-3">
  <h2 class="text-center">用户列表</h2>
  <a href="toAddUser.do" class="btn btn-primary m-3">添加用户</a>
  <table class="table table-bordered">
    <tr class="text-center">
      <th>编号</th>
      <th>姓名</th>
      <th>性别</th>
      <th>年龄</th>
      <th>头像</th>
      <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="user">
      <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.sex}</td>
        <td>${user.age}</td>
        <td><img src="upload/${user.headImg}" width="200" height="200"></td>
        <td><a href="toModifyUser.do?id=${user.id}" class="btn btn-info">修改</a>
<%--          <a href="javascript:void(0)" class="btn btn-danger" onclick="showDeleteModal(this)">删除</a></td>--%>
          <a href="#" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#myModal" onclick="showDeleteModal(this)">删除</a></td>
      </tr>
    </c:forEach>

  </table>

  <!-- 模态框 -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">

        <!-- 模态框头部 -->
        <div class="modal-header">
          <h4 class="modal-title">警告</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>

        <!-- 模态框内容 -->
        <div class="modal-body">
          <input type="hidden" id="deleteID" />
          确定删除该用户吗？
        </div>

        <!-- 模态框底部 -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" id="confirmDelete" data-bs-dismiss="modal">确定</button>
          <button type="button" class="btn btn-light" data-bs-dismiss="modal">关闭</button>
        </div>

      </div>
    </div>
  </div>

</div>

<script>
  $(function (){
    $("#confirmDelete").click(function (){
      window.location.href = "doDeleteUser.do?id="+$("#deleteID").val();
    });
  });
  function showDeleteModal(obj){
    let $tds = $(obj).parent().parent().children();
    let deleteID = $($tds[0]).html();
    console.log($($tds[0]).html());
    console.log($tds[0].innerHTML);
    $("#deleteID").val(deleteID);

    //$("#myModal").modal("show");  //通过js打开模态对话框
  }
</script>
</body>
</html>
