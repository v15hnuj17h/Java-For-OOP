// Create a class AreaCalc with overloaded area() methods:
// area(int side) → area of square
// area(int length, int width) → area of rectangle
// area(double radius) → area of circle (use Math.PI)
// In main: call all three versions and print results

class AreaCalc {

    int area(int side){
        return side*side;
    }

    int area(int length, int width){
        return length*width;
    }

    double area(double radius){
        return 3.14*radius*radius;
    }

}

public class OverloadedAreaCalculator {
    public static void main(String[] args) {
        AreaCalc a = new AreaCalc();
        System.out.println(a.area(10));
        System.out.println(a.area(3,8));
        System.out.println(a.area(1.0));

    }
}