<%--
  Created by IntelliJ IDEA.
  User: xiongzhilong
  Date: 2019-03-04
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="${pageContext.request.contextPath}/user/addUser" method="get">
    姓名：<input type="text" name="username"/></br>
    地址：<input type="text" name="address"/>
    <input type="submit" value="提交"/>

</form>

</body>
</html>
