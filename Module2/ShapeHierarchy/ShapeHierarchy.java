// Create:
// Parent class Shape with: color (String), displayColor() method
// Child class Circle extends Shape:
// attribute: radius (double)
// overrides: displayColor() to also print "I am a Circle"
// method: area() → πr²
// Child class Rectangle extends Shape:
// attributes: length, width (double)
// method: area() → l×w
// In main: create one of each, display color and area

class Shape {
    String color;

    Shape(String color){
        this.color = color;
    }

    void displayColor() {
        System.out.println("Color: "+ color);
    }
}

class Circle extends Shape{
    double radius;

    Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    @Override
    void displayColor(){
        super.displayColor();
        System.out.println("I'm also a circle. ");
    }

    double area(){
        return 3.1416*radius*radius;
    }

    void displayArea(){
        System.out.println("Area: "+ area());
    }
}

class Rectangle extends Shape{
    double length, width;

    Rectangle(String color, double length, double width){
        super(color);
        this.length = length;
        this.width = width;
    }

    double area(){
        return length*width;
    }

    void displayArea(){
        System.out.println("Area: "+ area());
    }
}

public class ShapeHierarchy {
    public static void main(String[] args) {
        
        Circle c = new Circle("red",10.0);
        Rectangle r = new Rectangle("yellow",50.5,100.0);

        c.displayArea();
        c.displayColor();
        System.out.println();
        r.displayArea();
        r.displayColor();

    }
}