<%--
  Created by IntelliJ IDEA.
  User: zhangweikang
  Date: 5/6/18
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
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
    ArrayList goodslist = shoppingService.getGoodsList();
%>
<table border = "1" width = "450" rules = "none" cellspacing = "0" cellpadding = "0" align="center">
    <tr height = "50">
        <td colspan="3" align="center">
            提供商品如下
        </td>
    </tr>
    <tr align="center" heigh = "30" bgcolor = "lightgrey">
        <td>名称</td>
        <td>价格（元/斤）</td>
        <td>购买</td>
    </tr>
    <% if(goodslist == null || goodslist.size() == 0){ %>
        <tr height="100">
            <td colspan="3" align="center">
                没有商品可显示
            </td>
        </tr>
    <% }
    else {
        for(int i = 0; i < goodslist.size(); i ++){
            GoodsSingle single = (GoodsSingle)goodslist.get(i);
    %>
    <tr height = "50" align = "center">
        <td><%=single.getName()%></td>
        <td><%=single.getPrice()%></td>
        <td>
            <a href="<%=path%>/doCar?action=buy&goods_name=<%=single.getName()%>">
                购买
            </a>
        </td>
    </tr>
    <%
            }
        } %>
    <tr heigh="50">
        <td colspan="3" align="center">
            <a href="./shopcar.jsp">
                查看购物车
            </a>
        </td>
    </tr>
</table>
</body>
</html>
