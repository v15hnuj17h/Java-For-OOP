import java.util.Scanner;

public class Rough {
    public static void main(String[] args) {
      


void setAge(int age) {
    if (age < 0 || age > 150) {
        throw new IllegalArgumentException(
            "Invalid age: " + age + ". Must be 0-150."
        );
    }
    this.age = age;
}

// Usage:
try {
    student.setAge(-5);
} catch (IllegalArgumentException e) {
    System.out.println("❌ " + e.getMessage());
}
// Output: ❌ Invalid age: -5. Must be 0-150.









    }
}
