package servlets;

import beans.TableDB;
import beans.Result;
import com.sun.net.httpserver.Authenticator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "AreaCheckServlet", value = "/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {

    private double X;
    private double Y;
    private double R;

    private boolean  validate(String x, String y, String r){
        try{
            X = Double.parseDouble(x);
            Y = Double.parseDouble(y);
            R = Double.parseDouble(r);
            if(X <= -3 || X >= 5 || R <= 1 || R >= 5 || Y <= -3 || Y <= 5) return false;
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }

    private boolean checkArea(double x, double y, double r){
        if(x >= 0 && y >= 0){
            return x*x + y*y <= r*r;
        }
        else if(x <= 0 && y >= 0){
            return x >= -r/2 && y <= r;
        }
        else if(x <= 0 && y <= 0){
            return -2 * x - r/2 <= y;
        }
        else return false;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long currentTime = System.currentTimeMillis();
        String x = request.getParameter("X");
        String y = request.getParameter("Y");
        String r = request.getParameter("R");
        if(validate(x, y, r)){
            log("data is correct");
            boolean inArea = checkArea(X, Y, R);
            double time = (System.currentTimeMillis() - currentTime) / 1000.0;

            TableDB table = (TableDB) request.getSession().getAttribute("table");
            if(table == null) table = new TableDB();


            Result row = new Result(X, Y, R, inArea, LocalDateTime.now(), time);
            table.getResults().add(row);
            request.getSession().setAttribute("table", table);

            response.setContentType("text/html");
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(row.toString().getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();

            log(table.toString());
            //getServletContext().getRequestDispatcher("/index.jsp").forward(request, response); //ничего не делает...

        }
        else log("data is incorrect");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
