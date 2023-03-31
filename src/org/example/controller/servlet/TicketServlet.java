package org.example.controller.servlet;

import org.example.service.TicketService;
import org.example.controller.util.RoutingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {
    private final TicketService ticketService = TicketService.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long flightId = req.getParameter("flightId") == null ? null : Long.valueOf(req.getParameter("flightId"));
        req.setAttribute("tickets",
                ticketService.findAllTicketsDtoByFlightId(flightId));
        RoutingUtil.forwardToJSP("tickets", req, resp);
    }
}
