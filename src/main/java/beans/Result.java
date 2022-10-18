package beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Result implements Serializable{
    public Result(){

    }

    public Result(double x, double y, double r, boolean inArea, LocalDateTime date, double time){
        this.x = x;
        this.y = y;
        this.r = r;
        this.time = time;
        this.inArea = inArea;
        this.date = date;
    }

    private double x;
    private double y;
    private double r;
    private boolean inArea;
    private LocalDateTime date;
    private double time;


    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", getX(), getY(), getR(), isInArea(),
                String.format("%.3f", getTime()), getDate().format(formatter));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public boolean isInArea() {
        return inArea;
    }

    public void setInArea(boolean inArea) {
        this.inArea = inArea;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
