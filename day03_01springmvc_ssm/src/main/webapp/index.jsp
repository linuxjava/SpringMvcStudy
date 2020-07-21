<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<body>
<a href="${pageContext.request.contextPath}/account/findAll">查找所有用户</a>

<form action="${pageContext.request.contextPath}/account/saveAccount" method="post">
    用户名:<input type="text" name="name">
    金额:<input type="text" name="money">
    <input type="submit" value="保存">
</form>
</body>
</html>
