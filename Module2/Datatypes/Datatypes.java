public class Datatypes{
    public static void main(String[] args){

        // Primitive datatypes in Java
        byte byteValue = 120;
        short shortValue = 32000;
        int intValue = 18;
        long longValue = 10000000000000L;   // large values
        float floatValue = 2.33f; 
        double doubleValue = 3.14159;   // precise
        char charValue = 'A';
        boolean booleanValue = true;

        // Common non-primitive datatypes in Java
        String stringValue = "Vishnujith";
        int[] intArrayValue = {1, 2, 3, 4, 5};

        // Calling/using all declared variables
        System.out.println("byte value: " + byteValue);
        System.out.println("short value: " + shortValue);
        System.out.println("int value: " + intValue);
        System.out.println("long value: " + longValue);
        System.out.println("float value: " + floatValue);
        System.out.println("double value: " + doubleValue);
        System.out.println("char value: " + charValue);
        System.out.println("boolean value: " + booleanValue);
        System.out.println("String value: " + stringValue);
        System.out.println("int array first element: " + intArrayValue[0]);

    }
}