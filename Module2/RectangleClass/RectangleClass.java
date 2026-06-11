// Create a class called Rectangle with:
// Attributes: length (double), width (double)
// Methods:
// calculateArea() → returns area
// calculatePerimeter() → returns perimeter
// displayInfo() → prints all details
// In main: create 2 Rectangle objects with different sizes, display both

class Rectangle {

    double length, width;

    double calculateArea() {
        return length * width;
    }

    double calculatePerimeter() {
        return (length + width) * 2;
    }

    void displayInfo() {
        System.out.println("Length: " + length + ", Width: " + width);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println();
    }
}
public class RectangleClass {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();

        r1.length = 10.5;
        r1.width = 3.7;
        r2.length = 3.4;
        r2.width = 7.5;

        r1.displayInfo();
        r2.displayInfo();
    }
}
