package org.example.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getParameterMap().forEach((key, value) -> System.out.println(key + ":" + Arrays.toString(value)));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
