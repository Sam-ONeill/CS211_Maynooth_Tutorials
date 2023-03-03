package Examples.AbstractClassExample;

public class Car extends Vehicle {
    public Car(int speed, int xPosition, int yPosition) {
        super(speed, xPosition, yPosition);
    }

    public void draw() {
        // Draw the car on the screen...
    }


    public static void main(String[] args) {
        Car myCar = new Car(10, 0, 0);  // Create a new Car object with speed 10 and starting position (0,0)

        myCar.moveRight();  // Move the car right by one unit
        myCar.moveDown();   // Move the car down by one unit
        myCar.moveLeft();   // Move the car left by one unit
        myCar.moveUp();     // Move the car up by one unit

        myCar.draw();       // Draw the car on the screen
    }
}