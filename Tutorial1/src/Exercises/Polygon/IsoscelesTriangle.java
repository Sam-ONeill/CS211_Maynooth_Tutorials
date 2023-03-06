package Exercises.Polygon;

public class IsoscelesTriangle extends Triangle {
    private double base;
    private double height;
    private double side;
    public IsoscelesTriangle(double base,  double height, double side) {
        super(base, height, side);
        this.base = base;
        this.height = height;
        this.side = side;
    }
    @Override
    public double area() {
        return 0.5 * base * height;
    }

    @Override
    public double perimeter() {
        return 2*side + base;
    }

}