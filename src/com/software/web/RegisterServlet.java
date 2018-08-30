package com.software.web;

import com.software.service.UsersService;
import com.software.domain.UserRegisterInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String act = request.getParameter("act");
        if (act.equals("register")) {
            register(request, response);
        } else if (act.equals("validate")) {
            validate(request, response);
        }
    }
    protected void validate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UsersService usersService = new UsersService();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String txt_name = request.getParameter("txt_name");
        if(usersService.validate(txt_name)){
            out.write("用户名已存在");
        }
    }
    protected void register(HttpServletRequest request, HttpServletResponse response) throws IOException {

        UsersService usersService = new UsersService();
        request.setCharacterEncoding("utf-8");

        UserRegisterInfo userRegisterInfo = new UserRegisterInfo();
        userRegisterInfo.setTxt_name(request.getParameter("txt_name"));
        userRegisterInfo.setPwd(request.getParameter("pwd"));
        userRegisterInfo.setEmail(request.getParameter("email"));
        userRegisterInfo.setSex(request.getParameter("sex"));
        userRegisterInfo.setTel(request.getParameter("tel"));
        userRegisterInfo.setAge(request.getParameter("age"));
        userRegisterInfo.setXueli(request.getParameter("xueli"));
        userRegisterInfo.setJianli(request.getParameter("jianli"));
        userRegisterInfo.setHabby(request.getParameterValues("habby"));
        userRegisterInfo.setID(request.getParameter("ID"));

        if (usersService.isExistName(userRegisterInfo.getTxt_name())){
            PrintWriter out=response.getWriter();
            out.println("<script language='javascript'>alert('The user name you filled in already exists!');</script>");
//            out.println("</HTML>");
            out.flush();
            out.close();
//            response.sendRedirect(request.getContextPath()+"/user/register.jsp");
//            request.getRequestDispatcher(request.getContextPath()+"/user/register.jsp");
        }else {
            if (usersService.register(userRegisterInfo)){
                response.sendRedirect(request.getContextPath()+"/user/register_ok.jsp");
            }else {
                response.sendRedirect(request.getContextPath()+"/user/error_register.jsp");
            }
        }
    }
}








