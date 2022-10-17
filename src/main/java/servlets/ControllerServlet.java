package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ControllerServlet", value = "/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("X") != null && request.getParameter("Y") != null && request.getParameter("R") != null){
            RequestDispatcher rd = request.getRequestDispatcher("AreaCheckServlet");
            rd.forward(request,response);
        }
        else if(request.getParameter("action") != null){
            request.getRequestDispatcher("TableControllerServlet").forward(request, response);
        }
        /*response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        // получаем параметр id
        String id = request.getParameter("id");

        try {
            writer.println("<h2>Id:" + id + "</h2>");
        } finally {
            writer.close();
        }
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
