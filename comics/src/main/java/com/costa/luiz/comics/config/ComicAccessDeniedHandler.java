package com.costa.luiz.comics.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ComicAccessDeniedHandler implements AccessDeniedHandler {

    public static ComicAccessDeniedHandler INSTANCE = new ComicAccessDeniedHandler();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) throws IOException, ServletException {
        HashMap<String, String> map = new HashMap<>(2);
        map.put("uri", request.getRequestURI());
        map.put("message", "Authentication failed. Try again using the properly input");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        String resBody = new ObjectMapper().writeValueAsString(map);
        PrintWriter responseWriter = response.getWriter();
        responseWriter.print(resBody);
        responseWriter.flush();
        responseWriter.close();
    }
}
