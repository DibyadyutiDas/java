class student{

    String name;
    int age;
    
    student()                          //? constructor have no return type
    {
        System.out.println("This is constructor");
    }

    public void print_name()
    {
        System.out.println(this.name);
        System.out.println(this.age);
    }
}

public class constructor_ {
    public static void main(String[] args) {
        
        student s1 = new student();         /*class name -> student ,s1 -> object name*/
        s1.name = "Dibya";
        s1.age = 20;
        s1.print_name();
    }
    // ram s1 = new ram();
}

// class ram{

//     ram_duplicate()             //? this is not a constructor
//     {
//         System.out.println("This is not a constructor");
//     }
// }