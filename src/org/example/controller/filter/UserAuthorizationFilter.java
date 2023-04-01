package org.example.controller.filter;

import org.example.controller.util.RoutingUtil;
import org.example.dto.ReadUserTransfer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebFilter("/*")
public class UserAuthorizationFilter implements Filter {

    private static final Set<String> PUBLICLY_AVAILABLE_URIS = Set.of(
            RoutingUtil.UrlConstants.LOGIN, RoutingUtil.UrlConstants.REGISTRATION, RoutingUtil.UrlConstants.AVATAR);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        if (isPubliclyAvailableURI(requestURI) || isUserLoggedIn(servletRequest))
            filterChain.doFilter(servletRequest, servletResponse);
        else {
//            String outOfUri = ((HttpServletRequest) servletRequest).getHeader("referer");
            ((HttpServletResponse) servletResponse).sendRedirect(RoutingUtil.UrlConstants.LOGIN);
        }
    }

    private boolean isPubliclyAvailableURI(String requestURI) {
        return PUBLICLY_AVAILABLE_URIS.stream().anyMatch(requestURI::startsWith);
    }

    private boolean isUserLoggedIn(ServletRequest servletRequest) {
        ReadUserTransfer user = (ReadUserTransfer) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return user != null;

    }

//    private boolean isNeedAuthorizedURI(String requestURI) {
//        return false;
//    }
}
