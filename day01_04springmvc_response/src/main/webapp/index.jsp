<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>SpringMvc start</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#staticResource").click(function () {
                alert('1111111')
            });

            $("#ajax").click(function () {
                alert('2222222')
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"response/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"name":"hehe","date":"2020-06-24","age":30}',
                    dataType:"json",//返回数据类型
                    type:"post",
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.name);
                        alert(data.age);
                        alert(data.date);
                    }
                });
            });

        })
    </script>
</head>
<body>
    <h3>返回String</h3>
    <a href="${pageContext.request.contextPath}/response/testString">返回String</a><br>

    <h3>返回void</h3>
    <a href="${pageContext.request.contextPath}/response/testVoid">返回void</a><br>

    <h3>返回ModelAndView</h3>
    <a href="${pageContext.request.contextPath}/response/testModelAndView">返回void</a><br>

    <h3>关键字转发和重定向</h3>
    <a href="${pageContext.request.contextPath}/response/testForwardOrRedirect">返回void</a><br>

    <h3>过滤静态资源</h3>
    <button id="staticResource">过滤静态资源</button>

    <h3>ajax(RequestBody和ResponseBody)</h3>
    <button id="ajax">ajax请求</button>
</body>
</html>
