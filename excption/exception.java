import java.util.*;
import java.io.*;
import java.lang.*;

class exception{
    public static void main(String[] args) {
        
        try {
            int a = 4;
            int b = a/0;
            System.out.println("Result = " + b);
        } catch (ArithmeticException e) {
            // TODO: handle exception
            System.out.println("Number is not divided by 0");
        }
    }
}