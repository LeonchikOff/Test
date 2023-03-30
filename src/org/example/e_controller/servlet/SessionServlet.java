package org.example.e_controller.servlet;

import org.example.c_dto.UserDataTransfer;

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
        UserDataTransfer userDataTransfer = (UserDataTransfer) session.getAttribute(USER);
        if(userDataTransfer == null) {
            userDataTransfer = UserDataTransfer.builder().id(25L).email("test@gmail.com").build();
            session.setAttribute(USER, userDataTransfer);
        }
    }
}