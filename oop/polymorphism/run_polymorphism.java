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
        System.out.println("Name : "+this.name);
    }
    public void print(int age)
    {
        System.out.println("Age :"+this.age);
    }
    public void print(String name,int age)
    {
        System.out.println("Name : "+this.name+"  Age :"+this.age);
    }
}

public class run_polymorphism {
    public static void main(String[] args) {
        
        student s1 = new student("John", 20);
        student s2 = new student("Jane", 22);

        s1.print("John");
        s1.print(20);
        s1.print("John", 20);

        s2.print("Jane");
        s2.print(22);
        s2.print("Jane", 22);
    }
}