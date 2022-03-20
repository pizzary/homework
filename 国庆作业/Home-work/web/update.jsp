<%@ page import="entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: 111
  Date: 2021/10/6
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>

    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<%

    Student student = (Student) request.getAttribute("student");

%>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="update" method="post">
        <div class="form-group">
            <input style="display: none" type="text" class="form-control" name="id" value="<%=student.getId()%>">
            <label for="name">姓名：</label>

            <input type="text" class="form-control" id="name" name="name" value="<%=student.getName()%>" readonly="readonly"  />
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="sex" value="男"  />男
            <input type="radio" name="sex" value="女"  />女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" value="<%=student.getAge()%>" name="age"  />
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" >
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control"value="<%=student.getQq()%>" name="qq" />
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" name="email"value="<%=student.getEmail()%>" />
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回"/>
        </div>

    </form>
</div>
</body>
</html>