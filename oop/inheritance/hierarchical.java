// Parent class
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

// Child class 1
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}

// Child class 2
class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing...");
    }
}

// Main class
public class hierarchical {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat(); // Accessing parent class method
        dog.bark(); // Accessing child class method

        Cat cat = new Cat();
        cat.eat(); // Accessing parent class method
        cat.meow(); // Accessing child class method
    }
}