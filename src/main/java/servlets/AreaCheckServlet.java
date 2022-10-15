package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AreaCheckServlet", value = "/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {

    private boolean  validate(String x, String y, String r){
        //проверка значений регуляркой?
        double X = Double.parseDouble(x);
        double Y = Double.parseDouble(y);
        double R = Double.parseDouble(r);
        return checkArea(X, Y, R);
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
        //add server validation
        String x = request.getParameter("X");
        String y = request.getParameter("Y");
        String r = request.getParameter("R");
        if(validate(x, y, r)){
            log("ok");
        }
        else log("fail");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
