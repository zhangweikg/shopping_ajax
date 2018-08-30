package com.software.web;

import com.software.service.ShoppingService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doCar")
public class BuyServlet extends HttpServlet {
    ShoppingService shoppingService = new ShoppingService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");// 获取action 参数值
        if(action == null){
            action = "";
        }
        if(action.equals("buy")) {   //出发购买请求
            buy(request, response); //调用buy()方法实现购买
        }
        if(action.equals("remove")) {//出发移除请求
            remove(request, response);//调用 remove（）方法实现商品的移除
        }
        if(action.equals("clear")) {//清除购物车
            clear(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    //实现上述购物的各种具体方法
    protected void buy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getContextPath();
        HttpSession session = request.getSession();
        if (shoppingService.buyTheGoods((String)session.getAttribute("txt_name"), request.getParameter("goods_name"))){
            response.sendRedirect(path + "/shopping/show_goods.jsp");//将请求重定向到show.jsp页面
        }
    }
    //实现商品移除
    protected void remove(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String path = request.getContextPath();
        HttpSession session = request.getSession();
        if (shoppingService.removeTheGoods((String)session.getAttribute("txt_name"), request.getParameter("goods_name"))){
            response.sendRedirect(path + "/shopping/shopcar.jsp");
        }
    }//实现清除购物车的方法
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String path = request.getContextPath();
        HttpSession session = request.getSession();
        if (shoppingService.clearShopCar((String)session.getAttribute("txt_name"))){
            response.sendRedirect(path + "/shopping/shopcar.jsp");
        }
    }
}
