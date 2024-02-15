package exercise;

import java.util.Comparator;

public class Cottage implements Home {
     private double area;
     private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
    @Override
    public double getArea(){
        return area;
    }

    @Override
    public int compareTo(Home home) {
        var areaThis = getArea(); var areaIn = home.getArea();
        if(this.getArea() < home.getArea()){
            return 1;
        } else if (this.getArea() > home.getArea()) {
            return -1;
        }
        else {
            return 0;
        }

    }

    public String toString(){
        return  (floorCount + " этажный коттедж площадью " + getArea() + " метров");
    }

}






