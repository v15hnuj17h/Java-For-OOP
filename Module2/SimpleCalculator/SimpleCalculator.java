// Write a program with two numbers num1 = 20 and num2 = 6:
// Print results of all 5 arithmetic operations
// Print which number is greater using relational operators
// Print if both numbers are even using logical + modulus operators

public class SimpleCalculator{
    public static void main(String[] args){
        
        int num1 = 20, num2 =6;

        System.out.println(num1+num2);
        System.out.println(num1-num2);
        System.out.println(num1*num2);
        System.out.println((double)num1/num2);
        System.out.println(num1%num2);

        System.out.println("Greater number = " + (num1 > num2 ? num1 : num2));

        System.out.print("Are both numbers even? " + ((num1 % 2 == 0) && (num2 % 2 == 0) ? "Yes" : "No"));

    }
}