interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();
}

class MyClass implements Interface1, Interface2 {
    public void method1()
    {
        System.out.println("Method 1");
    }

    public void method2()
    {
        System.out.println("Method 2");
    }
}

public class multiple {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.method1();
        obj.method2();
    }
}