package Exercises.Polygon;

public class Pentagon implements Polygon {
    private double side;

    public Pentagon(double side) {
        this.side = side;
    }

    public double area() {
        return (5 * side * side) / (4 * Math.tan(Math.PI / 5));

    }

    public double perimeter() {
        return 5*side;
    }
}
