public class Typecasting{
    public static void main(String[] args){
        
        // ==========================================================
        // 1) Declare all Java primitive data types
        // ==========================================================
        byte b = 10;
        short s = 200;
        int i = 1000;
        long l = 100000L;
        float f = 12.5f;
        double d = 99.999;
        char ch = 'A';
        boolean flag = true;

        // ==========================================================
        // 2) Widening casting (small -> large): automatic, no data loss
        // ==========================================================
        short bToS = b;      // byte -> short
        int sToI = s;        // short -> int
        long iToL = i;       // int -> long
        float lToF = l;      // long -> float
        double fToD = f;     // float -> double
        int chToI = ch;      // char -> int (ASCII/Unicode value of character)

        // ==========================================================
        // 3) Narrowing casting (large -> small): manual cast required
        //    Can lose data, decimal part can be removed, overflow can happen.
        // ==========================================================
        byte iToB = (byte) i;      // int -> byte (possible overflow)
        short lToS = (short) l;    // long -> short (possible overflow)
        int dToI = (int) d;        // double -> int (decimal part removed)
        char iToCh = (char) i;     // int -> char (number converted to Unicode char)
        int fToI = (int) f;        // float -> int (decimal part removed)

        // ==========================================================
        // 4) Typecasting that gives compile-time error (kept as comments)
        // ==========================================================
        // int boolToInt = (int) flag;
        // ERROR: boolean cannot be converted to int.
        // Teaching point: boolean is only true/false, not a numeric type.

        // boolean intToBool = (boolean) i;
        // ERROR: int cannot be converted to boolean.
        // Teaching point: numbers and boolean are unrelated in Java.

        // byte boolToByte = (byte) flag;
        // ERROR: boolean cannot be converted to byte.
        // Teaching point: boolean cannot be cast to any numeric type.

        // boolean chToBool = (boolean) ch;
        // ERROR: char cannot be converted to boolean.
        // Teaching point: char is numeric internally, boolean is logical only.

        // ==========================================================
        // 5) Print values to observe typecasting result
        // ==========================================================
        System.out.println("Original values:");
        System.out.println("byte b = " + b);
        System.out.println("short s = " + s);
        System.out.println("int i = " + i);
        System.out.println("long l = " + l);
        System.out.println("float f = " + f);
        System.out.println("double d = " + d);
        System.out.println("char ch = " + ch);
        System.out.println("boolean flag = " + flag);

        System.out.println("\nWidening casts:");
        System.out.println("byte -> short: " + bToS);
        System.out.println("short -> int: " + sToI);
        System.out.println("int -> long: " + iToL);
        System.out.println("long -> float: " + lToF);
        System.out.println("float -> double: " + fToD);
        System.out.println("char -> int: " + chToI);

        System.out.println("\nNarrowing casts:");
        System.out.println("int -> byte: " + iToB);
        System.out.println("long -> short: " + lToS);
        System.out.println("double -> int: " + dToI);
        System.out.println("int -> char: " + iToCh);
        System.out.println("float -> int: " + fToI);
    }
}