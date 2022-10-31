package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("X") != null && request.getParameter("Y") != null && request.getParameter("R") != null) {
            request.getRequestDispatcher("/AreaCheckServlet").forward(request, response);
        } else if (request.getParameter("action") != null) {
            request.getRequestDispatcher("TableControllerServlet").forward(request, response);
        } else request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
