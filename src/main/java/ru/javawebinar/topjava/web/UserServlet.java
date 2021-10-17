package ru.javawebinar.topjava.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    //private static final Logger LOG = LoggerFactory.getLogger(UserServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        LOG.debug("redirect to User");
        request.getRequestDispatcher("users.jsp").forward(request, response);
//        response.sendRedirect("users.jsp");
    }
}
