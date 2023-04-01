package org.example.controller.servlet;

import org.example.dto.CreateUserTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {
    private static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CreateUserTransfer createUserTransfer = (CreateUserTransfer) session.getAttribute(USER);
        if(createUserTransfer == null) {
            createUserTransfer = CreateUserTransfer.builder().email("test@gmail.com").build();
            session.setAttribute(USER, createUserTransfer);
        }
    }
}
