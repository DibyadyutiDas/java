import java.util.ArrayList;

public class arraylist {
    public static void main(String[] args){
    
        // * Arraylist is a resizable array ,Elements can be added and removed after compilation phase
        // it store reference data type
        
        ArrayList<String> food = new ArrayList<String>();
        
        food.add("Rice");
        food.add("Dal");
        food.add("Curry");

        // System.out.println(food);

        for (int i = 0; i < food.size(); i++) {
            System.out.println(food.get(i));
        }
    }
}
