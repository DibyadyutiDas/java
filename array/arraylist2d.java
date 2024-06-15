import java.util.ArrayList;

public class arraylist2d {
    public static void main(String[] args){
    
        
        ArrayList<ArrayList<String>> Vacation = new ArrayList<>();
        
        ArrayList<String> food = new ArrayList<>();
        food.add("Rice");
        food.add("Dal");
        food.add("Curry");

        // String[] drink = {"tea","coffee","cold_drink"}; // ! error
        ArrayList<String> drink = new ArrayList<>();
        drink.add("Tea");
        drink.add("Coffee");
        drink.add("Cold_drink");

        ArrayList<String> friend = new ArrayList<>();
        friend.add("Ram");
        friend.add("Syam");
        friend.add("Hari");
        
        Vacation.add(food);
        Vacation.add(drink);
        Vacation.add(friend);

        System.out.println(Vacation);

    //     System.out.println(drink[0]);
    }
}
