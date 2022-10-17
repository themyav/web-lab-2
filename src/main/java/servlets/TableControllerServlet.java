package servlets;

import beans.TableDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "TableControllerServlet", value = "/TableControllerServlet")
public class TableControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action").equals("clean")){
            TableDB table = new TableDB();
            request.getSession().setAttribute("table", table);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response); //нужно ли...
        }
        else if(request.getParameter("action").equals("fill")){

            TableDB table = (TableDB) request.getSession().getAttribute("table");
            if(table == null) table = new TableDB();

            response.setContentType("text/html");
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(table.toString().getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
