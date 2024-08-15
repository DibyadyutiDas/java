abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class abstraction {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        circle.draw();
        rectangle.draw();
    }
}

/*What is Abstraction?
 Abstraction is one of the four fundamental principles 
 of Object-Oriented Programming (OOP),
 alongside encapsulation, inheritance, and polymorphism. 
 Abstraction involves hiding the complex implementation details of a system 
 and exposing only the necessary and relevant parts to the user. 
 This helps in reducing complexity and allows the programmer to focus on 
 interactions at a higher level.*/