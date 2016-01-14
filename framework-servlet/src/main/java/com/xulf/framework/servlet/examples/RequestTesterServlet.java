package com.xulf.framework.servlet.examples;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xuliufeng on 2016/1/5.
 */
public class RequestTesterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        //url  http://localhost:8080/servlet/request
        writer.println("RequestUrl: " + req.getRequestURL());
        writer.close();
    }
}
