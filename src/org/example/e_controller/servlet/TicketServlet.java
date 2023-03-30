package org.example.e_controller.servlet;

import org.example.d_service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {
    private final TicketService ticketService = TicketService.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>List of purchased tickets: </h1>");
            writer.write("<ul>");
            ticketService.findAllTicketsDtoByFlightId(Long.valueOf((req.getParameter("flightId"))))
                    .forEach(flightDataTransfer -> {
                        writer.write("""
                                <li>
                                    Flight Id: %s, Ticket Id: %s, Seat Number: %s                            
                                </li>
                                """.formatted(
                                flightDataTransfer.getFlightId(),
                                flightDataTransfer.getId(),
                                flightDataTransfer.getSeatNumber())
                        );
                    });
            writer.write("</ul>");
        }
    }
}
