package beans;

import java.time.LocalDate;
import java.util.Date;
import java.io.Serializable;
import java.util.Locale;

public class Result implements Serializable{
    public Result(){

    }

    public Result(double x, double y, double r, boolean inArea, LocalDate date, double time){
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
    private LocalDate date;
    private double time;


    @Override
    public String toString(){
        return String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", getX(), getY(), getR(), getTime(), getDate());
        //return "<tr>" +getX() + " "  + getY() + " " + getR() + " " + isInArea() + " " + getDate() + " " + getTime();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
