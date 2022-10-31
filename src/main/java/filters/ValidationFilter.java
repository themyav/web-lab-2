package filters;

import javax.servlet.*;
import java.io.IOException;

public class ValidationFilter implements Filter {

    private boolean validate(String x, String y, String r) {
        try {
            double x1 = Double.parseDouble(x);
            double y1 = Double.parseDouble(y);
            double r1 = Double.parseDouble(r);
            if (x1 < -3 || x1 > 5 || r1 < 1 || r1 > 5 || y1 < -3 || y1 > 3) return false;
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String x = servletRequest.getParameter("X");
        String y = servletRequest.getParameter("Y").replace(",", ".");
        String r = servletRequest.getParameter("R");


        if (validate(x, y, r)) {
            System.out.println("data is correct");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("data is incorrect");
        }
    }
}
