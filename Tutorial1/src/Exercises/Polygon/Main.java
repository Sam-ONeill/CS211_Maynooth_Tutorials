package Exercises.Polygon;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("Choose a polygon to create:");
            System.out.println("1. Triangle");
            System.out.println("2. Quadrilateral");
            System.out.println("3. Square");
            System.out.println("4. Pentagon");
            System.out.println("5. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the length of the three sides:");
                    double side1 = scanner.nextDouble();
                    double side2 = scanner.nextDouble();
                    double side3 = scanner.nextDouble();
                    Triangle triangle = new Triangle(side1, side2, side3);
                    System.out.println("Perimeter: " + triangle.perimeter());
                    System.out.println("Area: " + triangle.area());
                    break;

                case 2:
                    System.out.println("Enter the length of the four sides:");
                    double sideA = scanner.nextDouble();
                    double sideB = scanner.nextDouble();
                    double sideC = scanner.nextDouble();
                    double sideD = scanner.nextDouble();
                    Quadrilateral quadrilateral = new Quadrilateral(sideA, sideB, sideC, sideD);
                    System.out.println("Perimeter: " + quadrilateral.perimeter());
                    System.out.println("Area: " + quadrilateral.area());
                    break;

                case 3:
                    System.out.println("Enter the length of one side:");
                    double side = scanner.nextDouble();
                    Square square = new Square(side);
                    System.out.println("Perimeter: " + square.perimeter());
                    System.out.println("Area: " + square.area());
                    break;

                case 4:
                    System.out.println("Enter the length of one side:");
                    double sideP = scanner.nextDouble();
                    Pentagon pentagon = new Pentagon(sideP);
                    System.out.println("Perimeter: " + pentagon.perimeter());
                    System.out.println("Area: " + pentagon.area());
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        }
    }
}
