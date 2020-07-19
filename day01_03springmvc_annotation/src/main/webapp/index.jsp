<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>SpringMvc start</title>
</head>
<body>
    <h3>RequestParam</h3>
    <a href="${pageContext.request.contextPath}/annotation/requestParam?username=哈哈哈">简单数据类型绑定</a><br>

    <h3>RequestBody</h3>
    <form method="post" action="${pageContext.request.contextPath}/annotation/requestBody">
        用户姓名:<input type="text" name="name"/><br>
        用户年龄:<input type="text" name="age"/><br>
        <input type="submit" value="提交">
    </form>

    <h3>PathVariable</h3>
    <a href="${pageContext.request.contextPath}/annotation/PathVariable/10">PathVariable注解测试</a><br>

    <h3>RequestHeader</h3>
    <a href="${pageContext.request.contextPath}/annotation/requestHeader">RequestHeader注解测试</a><br>

    <h3>CookieValue</h3>
    <a href="${pageContext.request.contextPath}/annotation/cookieValue">CookieValue注解测试</a><br>

    <h3>ModelAttribute</h3>
    <form method="post" action="${pageContext.request.contextPath}/annotation/modelAttribute">
        用户姓名:<input type="text" name="name"/><br>
        用户年龄:<input type="text" name="age"/><br>
        <input type="submit" value="提交">
    </form>

    <h3>SessionAttributes</h3>
    <a href="/annotation/setSessionAttribute">设置session数据</a><br>
    <a href="/annotation/getSessionAttribute">获取session数据</a><br>
    <a href="/annotation/removeSessionAttribute">删除session数据</a>
</body>
</html>
