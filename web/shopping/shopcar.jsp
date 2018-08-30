<%--
  Created by IntelliJ IDEA.
  User: zhangweikang
  Date: 5/6/18
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.software.domain.GoodsSingle" %>
<%@ page import="com.software.service.ShoppingService" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<%
    ShoppingService shoppingService = new ShoppingService();
    ArrayList buylist= shoppingService.getBuyList((String)session.getAttribute("txt_name"));
    float total=0;  //用来存储总金额
%>
<table border = "1" width = "450" rules = "none" cellspacing = "0" cellpadding = "0" align = "center">
    <tr height="50">
        <td colspan="6" align="center">
            购买商品如下
        </td>
    </tr>
    <tr align="center"heigh="30" bgcolor="lightgrey">
        <td weight="25%">名称</td>
        <td>价格（元/斤）</td>
        <td>数量</td>
        <td>总价</td>
        <td>移除（-1/次）</td>
        <%--<td>添加（+1/次）</td>--%>
    </tr>
    <% if(buylist==null||buylist.size()==0) { %>
    <tr height="100">
        <td colspan="6" align="center">
            您的购物车是空的
        </td>
    </tr>
    <%
    }
    else{
        for(int i=0;i<buylist.size();i++){
            GoodsSingle single=(GoodsSingle)buylist.get(i);
            String name=single.getName();  //获取商品名
            float price=single.getPrice();//获取商品价格
            int num=single.getNum();//获取购买数量
            //计算当前应付金额，并四舍五入
            float money=((int)((price*num+0.05f)*10))/10f;
            total+=money;
    %>
            <tr align="center" height="50">
                <td><%=name %></td>
                <td><%=price %></td>
                <td><%=num %></td>
                <td><%=money %></td>
                <td><a href="<%=path%>/doCar?action=remove&goods_name=<%=single.getName()%>">移除</a></td>
                <%--<td><a href="<%=path%>/doCar?action=add&goods_name=<%=single.getName()%>">添加</a></td>--%>
            </tr>
    <%
            }
        }
    %>
    <tr height="50"  align="center"><td colspan="6">应付金额：<%=total %></td></tr>
    <tr height="50"  align="center">
        <td colspan="3"><a href="show_goods.jsp">继续购物</a></td>
        <td colspan="3"><a href="<%=path%>/doCar?action=clear">清空购物车</a></td>
    </tr>
</table>
</body>
</html>
