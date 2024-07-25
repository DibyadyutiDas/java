class pen{
    String color;
    String type;
    
    void write()
    {
        System.out.println("Have a nice day");
    }
    public void print_color()
    {
        System.out.println(this.color + "pen " + this.type);
    }
}

public class object_ {
    public static void main(String[] args) {

        pen pen1 = new pen();
        pen1.color = "blue";
        pen1.type = "ball_pen";
        pen1.write();
        pen1.print_color();

        pen pen2 = new pen();
        pen2.color = "black";
        pen2.type = "gel_pen";
        pen2.write();
        pen1.print_color();
    }
}