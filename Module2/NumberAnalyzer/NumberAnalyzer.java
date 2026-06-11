// Expected Output:
// 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz
// 11 12 Fizz 14 FizzBuzz 16 17 Fizz 19 Buzz

public class NumberAnalyzer{
    public static void main (String[] args){
        
        for(int i = 1; i <=20; i++){
            System.out.printf((i % 3 == 0 && i % 5 == 0 ? "FizzBuzz" : i%3==0 ? "Fizz" : i%5==0 ? "Buzz" : i)+"\t");
        }
    }
}