public class printf {
    public static void main(String[] args) {
        boolean my_Boolean = true;
        char my_Char = '@';
        String my_String = "Dibya";
        int my_Integer = 42;
        long my_Long = 1234567890L;
        float my_Float = 3.14f;
        double my_Double = 10.8080d;

        System.out.printf("Boolean value: %b\n", my_Boolean);
        System.out.printf("Character value: %5c\n", my_Char);
        System.out.printf("String value: %s\n", my_String);
        System.out.printf("Integer value: %d\n", my_Integer);
        System.out.printf("Long value: %d\n", my_Long);
        System.out.printf("Float value: %.2f\n", my_Float);
        System.out.printf("Double value: %.2f\n", my_Double);
    }
}