// Parent class
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

// Child class inheriting from the parent class
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}

// Main class
public class single {
    public static void main(String[] args) {
        // Creating an object of the child class
        Dog dog = new Dog();

        // Calling methods from both parent and child classes
        dog.eat();
        dog.bark();
    }
}