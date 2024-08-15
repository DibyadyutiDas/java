class student{
    String name;
    int age;

    student(String name, int age)               //? parameterized constructor constructor
    {
        this.name = name;
        this.age = age;
    }

    public void print(String name)
    {
        System.out.println("Name : " +name);
    }
    public void print(int age)
    {
        System.out.println("Age :" +age);
    }
    public void print(String name,int age)
    {
        System.out.println("Name : "+name+"  Age :"+age);
    }
}

public class compile_polymorphism {
    public static void main(String[] args) {

        student s1 = new student("Dibya",20);   /*class name -> student ,s1 -> object name*/
        s1.print(s1.name);

        student s2 = new student("Dibyadyuti",20);
        s2.print(s2.name);
    }
}

