// Expected Output:
// Full Name  : John Doe
// Characters : 8
// First Char : J
// Last Char  : e
// Uppercase  : JOHN DOE
// Swapped    : Doe John
public class StringProblem{
    public static void main(String[] args){
        String name = "John Doe";
        int spaceIndex = name.indexOf(' ');
        String firstName = name.substring(0, spaceIndex);
        String lastName = name.substring(spaceIndex + 1);

        System.out.println("Full Name  : " + name);
        System.out.println("Characters : " + name.length());
        System.out.println("First Char : " + name.charAt(0));
        System.out.println("Last Char  : " + name.charAt(name.length() - 1));
        System.out.println("Uppercase  : " + name.toUpperCase());
        System.out.println("Swapped    : " + lastName + " " + firstName);
    }
}