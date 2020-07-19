<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>SpringMvc start</title>

</head>
<body>
    <h3>传统方式文件上传</h3>
    <form action="${pageContext.request.contextPath}/user/fileupload" method="post" enctype="multipart/form-data">
        文件上传<input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>

    <h3>SpringMvc方式文件上传</h3>
    <form action="${pageContext.request.contextPath}/user/springMvcUpload" method="post" enctype="multipart/form-data">
        文件上传<input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>

    <h3>SpringMvc方式跨服务器文件上传</h3>
    <form action="${pageContext.request.contextPath}/user/springMvcFileServer" method="post" enctype="multipart/form-data">
        文件上传<input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
