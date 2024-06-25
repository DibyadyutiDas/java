import java.util.*;

public class string1 {
    public static void main(String[] args){
    
        // * String = a reference data type that can store one or more characters reference 
        // * data types have access to useful methods

        String name = "Bro";
        String name2 = "Code";
        int result_i[] = new int[4];
        String result_s;

        result_i[0] = name.length();
        result_i[1]= name.indexOf("o");
        result_i[2] = name.compareTo(name2);

        // char result = name.charAt(0);
        // boolean result = name.equalsIgnoreCase("bro");
        // boolean result = name.isEmpty();

        // result_s[0] = name.toLowerCase();
        // result_s[1] = name.toUpperCase();
        // result_s[2] = name.trim();
        result_s = name.replace('o','a');
        // result_s = name.substring(1);

        for (int i = 0; i < result_i.length; i++)
        {
            System.out.println(result_i[i]);
        }
        // for (int i = 0; i < result_s.length; i++)
        // {
        //     System.out.println(result_s[i]);
        // }
        
        System.out.println(result_s);
    }
}
