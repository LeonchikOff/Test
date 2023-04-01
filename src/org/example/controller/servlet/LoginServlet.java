package org.example.controller.servlet;

import lombok.SneakyThrows;
import org.example.controller.util.RoutingUtil;
import org.example.dto.ReadUserTransfer;
import org.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(RoutingUtil.UrlConstants.LOGIN)
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserService.getService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoutingUtil.forwardToJSP("login", req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.login(
                req.getParameter("email"),
                req.getParameter("password")
        ).ifPresentOrElse(user -> onLoginSuccess(user, req, resp), () -> onLoginFail(req, resp));
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        resp.sendRedirect("/login?error&email=" + req.getParameter("email"));
    }

    @SneakyThrows
    private void onLoginSuccess(ReadUserTransfer user, HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("/flights");
    }
}
