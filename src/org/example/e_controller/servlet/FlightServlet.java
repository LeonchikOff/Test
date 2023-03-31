package org.example.e_controller.servlet;

import org.example.d_service.FlightService;
import org.example.e_controller.util.RoutingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {
    private final FlightService flightService = FlightService.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("flights", flightService.findAllFlightsDto());
        RoutingUtil.forwardToJSP("flights", req, resp);
    }
}
