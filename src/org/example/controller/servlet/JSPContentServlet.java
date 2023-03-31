package org.example.controller.servlet;

import org.example.dto.FlightDataTransfer;
import org.example.service.FlightService;
import org.example.controller.util.RoutingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/content")
public class JSPContentServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightDataTransfer> flightsDto = flightService.findAllFlightsDto();
        req.setAttribute("flights", flightsDto);
        req.getSession().setAttribute("flightsMapIdAndDesc", flightsDto.stream()
                .collect(Collectors.toMap(FlightDataTransfer::getId, FlightDataTransfer::getDescription)));
        RoutingUtil.forwardToJSP("template", req, resp);
    }
}
