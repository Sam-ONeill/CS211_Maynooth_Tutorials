package Exercises.Polygon;

public class Quadrilateral implements Polygon {
    private double a, b, c, d;

    public Quadrilateral(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double area() {
        double s = (a + b + c + d) / 2;
        double area = Math.sqrt((s-a)*(s-b)*(s-c)*(s-d));
        return area;
    }

    public double perimeter() {
        return a + b + c + d;
    }
}
