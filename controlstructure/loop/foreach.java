import java.util.ArrayList;

public class foreach {
    public static void main(String[] args){
    
        // *For-each loop = Traversing technique to iterate through the elements in an array 
        // *less step more readable more flexible
         
        // String[] animal = {"cat","dog","rat","bird"};

        ArrayList<String> animal = new ArrayList<String>();

        animal.add("cat");
        animal.add("dog");
        animal.add("rat");
        animal.add("bird");

        for(String i : animal){
            System.out.println(i);
        }
    }
}
