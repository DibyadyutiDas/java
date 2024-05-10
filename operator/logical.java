import java.util.*;

public class logical {
    public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter q to quit the game or enter p for play the game - ");
        String response = sc.next();
        
        if (response.equals("Q") || response.equals("q")) {
            System.out.println("You choice to quit the game");
        }
        else if(response != "p" && response != "P") {
            System.out.println("You choice to play the game");
        }
        else{
            System.out.println("you enter invalid option"); //! Not complete
        }
        
        sc.close();
    }
}
