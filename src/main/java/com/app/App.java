package com.app;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.util.logging.Logger;

public class App {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context ctx = tomcat.addContext("", null);
        Tomcat.addServlet(ctx, "HelloServlet", new HelloServlet());
        ctx.addServletMappingDecoded("/hello", "HelloServlet");

        try {
            tomcat.start();
            System.out.println("Tomcat started on port 8080");
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            Logger.getGlobal().severe("Tomcat failed to start: " + e.getMessage());
        }
    }
}
