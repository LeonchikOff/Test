package org.example.controller.servlet;

import lombok.SneakyThrows;
import org.example.controller.util.RoutingUtil;
import org.example.service.AvatarService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(RoutingUtil.UrlConstants.AVATAR + "/*")
public class AvatarServlet extends HttpServlet {
    private final AvatarService avatarService = AvatarService.getAvatarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String avatarPath = requestURI.replace("/images", "");

        avatarService.getAvatar(avatarPath).ifPresentOrElse(inputStream -> {
            resp.setContentType("application/octet-stream");
            writeAvatar(inputStream, resp);
        }, () -> resp.setStatus(404));

    }

    @SneakyThrows
    private void writeAvatar(InputStream inputStream, HttpServletResponse resp) {
        try (inputStream; ServletOutputStream outputStream = resp.getOutputStream()) {
            int currentByte;
            while ((currentByte = inputStream.read()) != -1)
                outputStream.write(currentByte);
        }
    }
}
