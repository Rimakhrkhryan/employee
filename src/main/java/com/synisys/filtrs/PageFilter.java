package com.synisys.filtrs;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by rima.khrkhryan on 3/16/2018.
 */
public class PageFilter implements Filter {
    public void  init(FilterConfig config) throws ServletException {

        String testParam = config.getInitParameter("test-param");
    }
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Cookie[] cookies = req.getCookies();
        boolean isAdmin = false;


        if (cookies != null) {
            for (Cookie cooke : cookies) {
                if (cooke.getName().equals("login")) {
                    isAdmin = true;
                }
            }
        }
        if(!(isAdmin) ){
            resp.sendRedirect("/index.jsp");
        }
        chain.doFilter(request, response);
    }
    public void destroy( ) {

    }
}
