public class copy_constructor {
    static class student{
        String name;
        int age;
        
        student(){
           //? constructor
        }
        
        student(student s2)               //? copy constructor
        {
            this.name = s2.name;
            this.age = s2.age;
        }
        
        void print()
        {
            System.out.println("Name : "+this.name+"  Age :"+this.age);
        }
    }
    
    public static void main(String[] args) {
        
        student s1 = new student();         /*class name -> student ,s1 -> object name*/
        s1.name = "Dibya";
        s1.age =20;
        
        student s2 = new student(s1);
        s2.print();
    }
}