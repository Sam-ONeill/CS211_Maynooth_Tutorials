package Exercises.Polygon;

public class EquilateralTriangle extends Triangle {
    private double side;
    public EquilateralTriangle(double side) {
        super(side, side, side);
        this.side = side;
    }
    @Override
    public double area() {
        return (Math.sqrt(3) / 4) * side * side;
    }

    @Override
    public double perimeter() {
        return side*3;
    }
}