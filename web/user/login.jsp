<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%String path = request.getContextPath(); %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户登录</title>
</head>

<body>
<br/>
<h1 align="center">嘻&nbsp;&nbsp;&nbsp;&nbsp;哈&nbsp;&nbsp;&nbsp;&nbsp;购&nbsp;&nbsp;&nbsp;&nbsp;物&nbsp;&nbsp;&nbsp;&nbsp;网</h1>
<br/> <br/>
<form id="form1" name="form1" method="post" action="<%=path%>/LogServlet" align="center">
    用户名：
    <input name="txt_name" type="text" id="txt_name" />
    <br />
    <br />
    密&nbsp;&nbsp;码：
    <input name="pwd" type="password" id="pwd" />
    <br />
    <br />
    <input type="submit" name="submit" value="登录" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" name="reset" value="重置" />
</form>
<p align="center">
    <a href="<%=path%>/user/register.jsp" >没有账号？赶紧注册吧。。。</a>
</p>
</body>
</html>
