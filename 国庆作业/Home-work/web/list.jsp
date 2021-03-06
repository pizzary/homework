<%@ page import="entity.Student" %>
<%@ page import="entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 111
  Date: 2021/10/6
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<%
    List<Student> list =(List<Student>) request.getAttribute("list");
%>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <br/>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <%
            for (Student s:list){
        %>

        <tr>
            <td><%=s.getId()%></td>
            <td><%=s.getName()%></td>
            <td><%=s.getSex()%></td>
            <td><%=s.getAge()%></td>
            <td><%=s.getAddress()%></td>
            <td><%=s.getQq()%></td>
            <td><%=s.getEmail()%></td>
            <td><a class="btn btn-default btn-sm" href="selectById?id=<%=s.getId()%>">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="javascript:del(<%=s.getId()%>)">删除</a></td>
        </tr>
        <%
            }
        %>
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary" href="add.html">添加联系人</a></td>
        </tr>
    </table>
</div>
<script>
    function del(id) {
        var b = window.confirm("确定删除吗？")
        if(b){
            // 去执行删除的servlet
     location.href="delete?id="+id;
     }
     }
</script>
</body>

</html>