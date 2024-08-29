package com.app;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(HelloServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String method = req.getMethod();
        String uri = req.getRequestURI();
        String clientIP = req.getRemoteAddr();

        logger.info("Received " + method + " request for " + uri + " from " + clientIP);

//        res.setContentType("text/plain");
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
//        out.println("Hello, World!");
        out.println("<html><body><h1>Hello, World!</h1></body></html>");
    }
}
