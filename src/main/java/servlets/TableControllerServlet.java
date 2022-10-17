package servlets;

import beans.TableDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TableControllerServlet", value = "/TableControllerServlet")
public class TableControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action").equals("clean")){
            TableDB table = new TableDB();
            request.getSession().setAttribute("table", table);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response); //нужно ли...
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
