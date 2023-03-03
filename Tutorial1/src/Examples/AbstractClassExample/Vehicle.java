package Examples.AbstractClassExample;

public abstract class Vehicle implements Movable {
    protected int speed;
    protected int xPosition;
    protected int yPosition;

    public Vehicle(int speed, int xPosition, int yPosition) {
        this.speed = speed;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void moveUp() {
        yPosition -= speed;
    }

    public void moveDown() {
        yPosition += speed;
    }

    public void moveLeft() {
        xPosition -= speed;
    }

    public void moveRight() {
        xPosition += speed;
    }

    public abstract void draw();
}
