package exercise;

public  class Flat implements Home{
private double area;
private double balconyArea;
private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return (area + balconyArea);
    }

    @Override
    public int compareTo(Home home) {
        var areaThis = getArea();
        var areaIn = home.getArea();
        if(this.getArea() > home.getArea()){
            return 1;
        }
        else if(this.getArea() < home.getArea()){
            return -1;
        }
        else{
            return 0;
        }
    }


    public String toString(){
      return ("Квартира площадью " + getArea() + " метров на " + floor + " этаже");

    }

}
