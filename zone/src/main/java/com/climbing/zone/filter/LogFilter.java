package com.climbing.zone.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

//public class LogFilter implements Filter {
//    public LogFilter() {
//    }
//
//    @Override
//    public void init(FilterConfig fConfig) throws ServletException {
//        System.out.println("LogFilter init!");
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("LogFilter destroy!");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        String servletPath = req.getServletPath();
//
//        System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath //
//                + ", URL =" + req.getRequestURL());
//
//        // Passez à l'élément suivant (filtre ou cible) en chaîne.
//        chain.doFilter(request, response);
//    }

//}
