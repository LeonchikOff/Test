package org.example.e_controller.util;

import lombok.experimental.UtilityClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@UtilityClass
public class RoutingUtil {
    private final String JSP_PATH = "/WEB-INF/jsp/%s.jsp";

    public static void forwardToJSP(String jspName, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(JSP_PATH.formatted(jspName)).forward(req, resp);
    }
}
