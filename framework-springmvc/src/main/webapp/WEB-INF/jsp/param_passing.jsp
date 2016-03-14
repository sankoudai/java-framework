<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form method="get" action="/springmvc/param/simple">
        <input name = "id" value="1"/>
        <input name = "name" value="jim"/>
        <input type="submit" value="提交"/>
    </form>

    <form method="get" action="/springmvc/param/composite">
        <input name = "id" value="1"/>
        <input name = "simpleObject.name" value="jim"/>
        <input name="mapObject[name]" value="jean"/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>