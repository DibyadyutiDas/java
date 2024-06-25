public class wrapper {
    public static void main(String[] args){
    
        // *Wrapper class  = Provides a way to use primitive data types as reference data types 
        // * reference data types contain some useful methods can be caused with collection

        // ? PRIMITIVE                WRAPPER CLASS
        // ? int                      Integer
        // ? char                     Character
        // ? double                   Double
        // ? boolean                  Boolean

    //! autoboxing = The automatic conversion of primitive data type to non_primitive datatype is called autoboxing
    //! unboxing = The revers of autoboxing is called unboxing, conversion of wrapper class to primitive datatype

        // Boolean a = true;
        // Integer b = 4;
        // Character c = 'c';
        // String d = "Bro";

        //     if (a == true) {
        //         System.out.println("This is true");
        //     }

        // System.out.println();
        Integer intObj = Integer.valueOf(1);
        int primitiveInt = intObj.intValue();
        System.out.println(primitiveInt);
    }
}
