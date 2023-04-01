package org.example.controller.servlet;

import org.example.dto.UserDataTransfer;
import org.example.service.UserService;
import org.example.controller.util.RoutingUtil;
import org.example.exception.ValidationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024*1024)
@WebServlet("/registration")
public class UserRegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", List.of("ADMIN", "USER"));
        req.setAttribute("genders", List.of("MALE", "FEMALE"));
        RoutingUtil.forwardToJSP("registration", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDataTransfer userDataTransfer = UserDataTransfer.builder()
                .avatar(req.getPart("avatar"))
                .name(req.getParameter("username"))
                .dateOfBirth(req.getParameter("birthDate"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .role(req.getParameter("role"))
                .gender(req.getParameter("gender"))
                .build();
        try {
            if (userService.createUserAndGetId(userDataTransfer) != null)
                resp.sendRedirect("/login");
        } catch (ValidationException e) {
            req.setAttribute("constraints", e.getConstraints());
            doGet(req, resp);
        }
    }
}
