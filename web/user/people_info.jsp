<%@ page import="com.software.domain.UserRegisterInfo" %>
<%@ page import="com.software.service.UsersService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人主页</title>
</head>
<body>

<h1>个人主页</h1><br>
<hr>
<%
//    UserRegisterInfo userRegisterInfo = (UserRegisterInfo) session.getAttribute("userRegisterInfo");
    //session.getAttribute()方法获取的结果是 Object 类型，需要强转
    UsersService usersService = new UsersService();
    UserRegisterInfo userRegisterInfo = usersService.getUserInfo((String)session.getAttribute("txt_name"));

    String txt_name = userRegisterInfo.getTxt_name() ;
    String pwd = userRegisterInfo.getPwd();
    String email = userRegisterInfo.getEmail();
    String tel = userRegisterInfo.getTel();
    String sex = userRegisterInfo.getSex();
    String age = userRegisterInfo.getAge();
    String xueli = userRegisterInfo.getXueli();
    String jianli = userRegisterInfo.getJianli();
    String[] habby = userRegisterInfo.getHabby();
    String ID = userRegisterInfo.getID();
%>

<table width="620" border="0" align="center">
    <tr>
        <td>用户名</td>
        <td><%=txt_name%></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><%=pwd%></td>
    </tr>
    <tr>
        <td>电子邮箱</td>
        <td><%=email%></td>
    </tr>
    <tr>
        <td>电话</td>
        <td><%=tel%></td>
    </tr>
    <tr>
        <td>性别</td>
        <td>
            <%if(Integer.parseInt(sex)==0){%>
                男
            <%}else{%>
                女
            <%}%>
        </td>
    </tr>
    <tr>
        <td>年龄</td>
        <td><%=age%></td>
    </tr>
    <tr>
        <td>学历</td>
        <td>
            <%int xueli_num = Integer.parseInt(xueli);
            if(xueli_num==1){%>
                小学生
            <%}else if(xueli_num==2){%>
                初中生
            <%}else if(xueli_num==3){%>
                高中生
            <%}else if(xueli_num==4){%>
                大学生
            <%}else if(xueli_num==5){%>
                研究生
            <%}else if(xueli_num==6){%>
                博 士
            <%}else{%>
                博士后
            <%}%>
        </td>
    </tr>
    <tr>
        <td>简历</td>
        <td><%=jianli%></td>
    </tr>
    <tr>
        <td>爱好</td>
        <td>
            <%String[] ha = new String[]{"足球", "篮球", "音乐"};%>
            <%for(int i = 0; i < habby.length; i++){ %>
            <%=ha[Integer.parseInt(habby[i])]%>
            <%}%>
        </td>
    </tr>
    <tr>
        <td>身份证号</td>
        <td><%=ID%></td>
    </tr>
</table>

</body>
</html>
