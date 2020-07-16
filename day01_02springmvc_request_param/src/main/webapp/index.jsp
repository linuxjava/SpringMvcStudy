<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMvc start</title>
</head>
<body>
    <h3>简单数据类型绑定</h3>
    <a href="user/testParam?username=xxx&age=18">简单数据类型绑定</a><br>

    <h3>JavaBean数据绑定</h3>
    <form method="post" action="/user/testParam1">
        用户账户:<input type="text" name="account"/><br>
        密码:<input type="text" name="password"/><br>
        邮箱:<input type="text" name="email"/><br>

        用户姓名:<input type="text" name="user.name"/><br>
        年龄:<input type="text" name="user.age"/><br>
        <input type="submit" value="提交">
    </form>

    <h3>List和Map数据绑定</h3>
    <form method="post" action="/user/testParam2">
        用户账户:<input type="text" name="account"/><br>
        密码:<input type="text" name="password"/><br>
        邮箱:<input type="text" name="email"/><br>

        用户姓名:<input type="text" name="list[0].name"/><br>
        年龄:<input type="text" name="list[0].age"/><br>

        用户姓名:<input type="text" name="list[1].name"/><br>
        年龄:<input type="text" name="list[1].age"/><br>

        用户姓名:<input type="text" name="map['one'].name"/><br>
        年龄:<input type="text" name="map['one'].age"/><br>

        用户姓名:<input type="text" name="map['two'].name"/><br>
        年龄:<input type="text" name="map['two'].age"/><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
