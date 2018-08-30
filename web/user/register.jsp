<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>嘻哈会员注册</title>
    <script type="text/javascript" src="../js/js1.js"></script>
    <link href="css/css1.css" type="text/css" rel="stylesheet" />
    <%String path = request.getContextPath(); %>
    <script type="text/javascript">
        function createXmlHttpRequest(){
            var httpReq ;
            try{    //Firefox, Opera 8.0+, Safari…
                httpReq=new XMLHttpRequest();
            }catch (e){
                try{    //Internet Explorer
                    httpReq =new ActiveXObject("Msxml2.XMLHTTP");
                }catch (e){
                    try{
                        httpReq=new ActiveXObject("Microsoft.XMLHTTP");
                    }catch (e){}
                }
            }
            return httpReq ;
        }

        //初始化XmlHttpRequest对象
        var httpReq = createXmlHttpRequest();
        function txt_nameValidate(){
            var txt_name = document.form1.txt_name.value;
            httpReq.open("post", "<%=path%>/RegisterServlet", "true");
            httpReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            httpReq.onreadystatechange=processResponse;
            httpReq.send("act=validate&txt_name=" + txt_name);

        }
        function processResponse() {// 处理返回信息的函数
            if(httpReq.readyState==4){
                if(httpReq.status==200){
                    document.getElementById("txt_nameInfo").innerHTML= httpReq.responseText;
                }
            }
        }

    </script>


</head>

<%--<%request.setCharacterEncoding("utf-8");%>--%>
<body>
<form name="form1" action="<%=path%>/RegisterServlet" method="post" onsubmit="return checkForm()">
    <input type="hidden" name="act" value="register"/>
    <table width="620" border="0" align="center">
        <!--<table width="620" border="0" align="center" style="border:1px #630 solid;">-->
        <tr>
            <td colspan="3" align="center">还没有嘻哈账号？赶紧注册吧！</td>
        </tr>
        <tr height="50">
            <td width="110"><label for="txt_name">用户名</label></td>
            <td width="280">*
                <%--<input type="text" id="txt_name" name="txt_name" value="请输入用户名" onclick="selTxt_Name()" onblur="checkName()" size="19" maxlength="12" />--%>
                <input type="text" id="txt_name" name="txt_name" value="请输入用户名" onclick="selTxt_Name()" onblur="checkName();txt_nameValidate()" size="19" maxlength="12" />
                <input type="button" name="txtname" value="清空" onclick="form1.txt_name.value=''" />
                <font color="red" id="txt_nameInfo"></font><br/>
            </td>
            <td>
                <div id="div1">用户名长度6~12位，不能包含空格。</div>
                <div id="div2">错误(请注意用户名长度)</div>
                <div id="div3">正确</div>
            </td>
        </tr>
        <tr height="50">
            <td><label for="pwd">密码</label></td>
            <td>*
                <input type="password" id="pwd" name="pwd" size="33" onblur="checkPassword()" />
                <!--
                    onfocus：当 input 输入框获取焦点时执行Javascript代码
                -->
            </td>
            <td>
                <div id="divPassword">
                    密码要求长度6-12位，且必须包含字母和数字，区分大小写
                </div>
            </td>
        </tr>
        <tr height="50">
            <td><label for="confirmed">确认密码</label></td>
            <td>*
                <input type="password" id="confirmed" name="confirmed" size="33" onblur="checkConfirmed()" />
            </td>
            <td>
                <div id="divconfirmed">
                    请确保与第一次输入的密码一致！
                </div>
            </td>
        </tr>
        <tr height="50">
            <td>出生日期</td>
            <td width="270">*
                <select name="YYYY" onChange="YYYYDD(this.value)">
                    <option value="">请选择 年</option>
                </select>
                <select name="MM" onChange="MMDD(this.value)">
                    <option value="">选择 月</option>
                </select>
                <select name="DD">
                    <option value="">选择 日</option>
                </select>
            </td>
            <td>&nbsp;</td>
        </tr>

        <script language="JavaScript">
            function YYYYMMDDstart() {
                MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
                //先给年下拉框赋内容
                var y = new Date().getFullYear();
                for(var i = (y - 30); i < (y + 30); i++) //以今年为准，前30年，后30年
                    document.form1.YYYY.options.add(new Option(" " + i + " 年", i));
                //赋月份的下拉框
                for(var i = 1; i < 13; i++)
                    document.form1.MM.options.add(new Option(" " + i + " 月", i));
                document.form1.YYYY.value = y;
                document.form1.MM.value = new Date().getMonth() + 1;
                var n = MonHead[new Date().getMonth()];
                if(new Date().getMonth() == 1 && IsPinYear(YYYYvalue)) n++;
                writeDay(n); //赋日期下拉框Author:meizz
                document.form1.DD.value = new Date().getDate();
            }
            if(document.attachEvent)
                window.attachEvent("onload", YYYYMMDDstart);
            else
                window.addEventListener('load', YYYYMMDDstart, false);

            function YYYYDD(str) //年发生变化时日期发生变化(主要是判断闰平年)
            {
                var MMvalue = document.form1.MM.options[document.form1.MM.selectedIndex].value;
                if(MMvalue == "") {
                    var e = document.form1.DD;
                    optionsClear(e);
                    return;
                }
                var n = MonHead[MMvalue - 1];
                if(MMvalue == 2 && IsPinYear(str)) n++;
                writeDay(n)
            }

            function MMDD(str) //月发生变化时日期联动
            {
                var YYYYvalue = document.form1.YYYY.options[document.form1.YYYY.selectedIndex].value;
                if(YYYYvalue == "") {
                    var e = document.form1.DD;
                    optionsClear(e);
                    return;
                }
                var n = MonHead[str - 1];
                if(str == 2 && IsPinYear(YYYYvalue)) n++;
                writeDay(n)
            }

            function writeDay(n) //据条件写日期的下拉框
            {
                var e = document.form1.DD;
                optionsClear(e);
                for(var i = 1; i < (n + 1); i++)
                    e.options.add(new Option(" " + i + " 日", i));
            }

            function IsPinYear(year) //判断是否闰平年
            {
                return(0 == year % 4 && (year % 100 != 0 || year % 400 == 0));
            }

            function optionsClear(e) {
                e.options.length = 1;
            }
        </script>

        <tr height="50">
            <td><label for="email">关联备用邮箱</label></td>
            <td>*
                <input type="text" id="email" name="email" value="" size="33" onblur="checkEmail()" maxlength="20" />
                <!--
                    onblur：
                    onblur 事件会在对象失去焦点时发生。
                -->
            </td>
            <td>
                <div id="divEmail">
                    当您忘记邮箱密码时，可通过此关联邮箱取回
                </div>
            </td>
        </tr>
        <tr height="50">
            <td><label for="tel">电话号码</label></td>
            <td>*
                <input type="text" id="tel" name="tel" value="" size="23" maxlength="11" />
                <input type="checkbox" name="lock" id="lock" onclick="form1.tel.readOnly=form1.lock.checked" /><label for="lock">锁定</label>

                <!--readonly="readonly" 只读-->
            </td>
            <td>用来接收验证消息等</td>
            <td>&nbsp;</td>
        </tr>
        <tr height="50">
            <td>性别</td>
            <td>*
                <input type="radio" id="sex1" name="sex" value="0"><label for="sex1">男</label>
                <input type="radio" id="sex2" name="sex" value="1"><label for="sex2">女</label>
                <!--name的值必须一样-->
            </td>
            <td>
                <div id="divsex"></div>
            </td>
        </tr>
        <tr height="50">
            <td>年龄</td>
            <td>*
                <input type="text" id="age" name="age" value="" size="33" maxlength="3" onblur="checkAge()" />
            </td>
            <td>
                <div id="divage">
                    只能输入数字格式，且值大于0
                </div>
            </td>
        </tr>
        <tr height="50">
            <td>学历</td>
            <td>*
                <select name="xueli" id="xueli">
                    <option value="0" selected="selected">请选择</option>
                    <option value="1">小学生</option>
                    <option value="2">初中生</option>
                    <option value="3">高中生</option>
                    <option value="4">大学生</option>
                    <option value="5">研究生</option>
                    <option value="6">博 士</option>
                    <option value="7">博士后</option>
                </select>
            </td>
            <td>
                <div id="divxueli"></div>
            </td>
        </tr>
        <tr height="50">
            <td><label for="jianli">个人简历</label></td>
            <td>
                <textarea rows="3" cols="36" name="jianli" id="jianli" onclick="selText()" onblur="checkJianli()"></textarea>
            </td>
            <td>
                <div id="divjianli">请输入简历，字数控制在200字以内！</div>
            </td>
        </tr>
        <tr height="50">
            <td>爱好</td>
            <td>*
                <input type="checkbox" name="habby" value="0"> 足球
                <input type="checkbox" name="habby" value="1"> 篮球
                <input type="checkbox" name="habby" value="2"> 音乐
            </td>
            <td>
                <div id="divhobby">请至少选两项</div>
            </td>
        </tr>
        <tr height="50">
            <td><label for="ID">身份证号</label></td>
            <td>*
                <input type="text" id="ID" name="ID" value="" size="33" onblur="checkIDnumber()" d maxlength="18" />
            </td>
            <td>
                <div id="divID">
                    请认真填写！
                </div>
            </td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td align="left" valign="middle">
                <input type="checkbox" id="service" name="service" onclick="form1.sub.disabled=!form1.service.checked" value="1" />
                <label for="service">我同意协议</label>
                <a href="term of service.html">嘻哈网服务条款</a>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>
                <input type="submit" value="注册" disabled="disabled" name="sub" />
                <input type="reset" value="重写" />
            </td>
        </tr>
    </table>
</form>
</body>

</html>
