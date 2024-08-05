// Parent class
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

// Child class 1
class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}

// Child class 2
class Cat extends Animal {
    void meow() {
        System.out.println("Meowing...");
    }
}

// Grandchild class
class Lion extends Cat {
    void roar() {
        System.out.println("Roaring...");
    }
}

// Main class
public class hybridInheritance {
    public static void main(String[] args) {
        Lion lion = new Lion();
        lion.eat();  // Accessing method from Animal class
        lion.meow(); // Accessing method from Cat class
        lion.roar(); // Accessing method from Lion class
    }
}