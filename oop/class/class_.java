// Define a class called MyClass
class MyClass {
    // Define a member variable
    int myVariable;

    // Define a constructor
    public MyClass(int value) {
        myVariable = value;
    }

    // Define a method
    public void printValue() {
        System.out.println("The value of myVariable is: " + myVariable);
    }
}

// Main class
public class class_{
    public static void main(String[] args) {
        // Create an instance of MyClass
        MyClass obj = new MyClass(10);

        // Call the printValue method
        obj.printValue();
    }
}