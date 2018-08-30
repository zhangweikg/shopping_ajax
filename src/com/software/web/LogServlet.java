package com.software.web;

import com.software.service.UsersService;
//import com.toolbean.UserLog;
import com.software.domain.UserLogInfo;
//import com.software.domain.UserRegisterInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        UserLogInfo userLogInfo = new UserLogInfo();
        UsersService usersService = new UsersService();

        userLogInfo.setTxt_name(request.getParameter("txt_name"));
        userLogInfo.setPwd(request.getParameter("pwd"));

        if(usersService.login(userLogInfo)){ //session.getAttribute()方法获取的结果是 Object 类型，需要强转
            request.getSession().setAttribute("txt_name", userLogInfo.getTxt_name());
            response.sendRedirect(request.getContextPath()+"/user/login_ok.jsp");
        }else{
            response.sendRedirect(request.getContextPath()+"/user/error.jsp");
        }
    }
}