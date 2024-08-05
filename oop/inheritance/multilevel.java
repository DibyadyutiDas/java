// Parent class
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

// Child class inheriting from Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

// Grandchild class inheriting from Dog
class Labrador extends Dog {
    void run() {
        System.out.println("Running...");
    }
}

// Main class
public class multilevel {
    public static void main(String[] args) {
        Labrador labrador = new Labrador();
        labrador.eat(); // Accessing method from Animal class
        labrador.bark(); // Accessing method from Dog class
        labrador.run(); // Accessing method from Labrador class
    }
}