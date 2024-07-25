class student{
    String name;
    int age;

    student(String name, int age)               //? parameterized constructor constructor
    {
        this.name = name;
        this.age = age;
    }

    void print()
    {
        System.out.println("Name : "+this.name+"  Age :"+this.age);
    }
}

public class parameter_constructor{
    public static void main(String[] args) {
        
        student s1 = new student("Dibya",20);   /*class name -> student ,s1 -> object name*/
        s1.print();

        student s2 = new student("Dibyadyuti",20);
        s2.print();
    }
}