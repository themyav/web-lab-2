package servlets;

import beans.TableDB;
import beans.Result;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;


@WebServlet(name = "AreaCheckServlet", value = "/AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {
    private boolean checkArea(double x, double y, double r) {
        if (x >= 0 && y >= 0) {
            return x * x + y * y <= r * r;
        } else if (x <= 0 && y >= 0) {
            return x >= -r / 2 && y <= r;
        } else if (x <= 0 && y <= 0) {
            return -2 * x - r / 2 <= y;
        } else return false;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long currentTime = System.currentTimeMillis();
        double x = Double.parseDouble(request.getParameter("X"));
        double y = Double.parseDouble(request.getParameter("Y").replace(",", "."));
        double r = Double.parseDouble(request.getParameter("R"));

        boolean inArea = checkArea(x, y, r);
        double time = (System.currentTimeMillis() - currentTime) / 1000.0;

        TableDB table = (TableDB) request.getSession().getAttribute("table");
        if (table == null) table = new TableDB();


        Result row = new Result(x, y, r, inArea, LocalDateTime.now(), time);
        table.getResults().add(row);
        request.getSession().setAttribute("table", table);

        response.setContentType("text/html");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(row.toString().getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
