package exercise;

public class Segment {
    Point point1 = new Point();
    Point point2 = new Point();

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }


    public Point getBeginPoint(){
        return point1;

}
public Point getEndPoint(){
        return point2;

}
public Point getMidPoint(){
       int xx = ((point1.getX() + point2.getX()) / 2);
       int yy =((point1.getY() + point2.getY()) / 2);
       Point point3 = new Point(xx,yy);
       return point3;

}
}
