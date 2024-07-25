// package java.constructor;

public class car {
    String color;
    int year;

    //constructor
    public car(String color,int year){
        this.color = color;
        this.year = year;
    }

    //main method
    public static void main(String[] args) {
        car my_car = new car ("Red",2020);
        System.out.println("color: "+my_car.color+"\nyear: "+my_car.year);
    }
}