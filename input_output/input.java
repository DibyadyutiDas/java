import java.util.*;

public class input {
    public static void main(String[] args){
    
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name - ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age - ");
        int age = scanner.nextInt();                    // !It consume another line after it 
        scanner.nextLine();                             // !It makeup the line that consume by nextInt()
                                                        // todo: Without this we can't enter nextLine
                                                        
        System.out.print("What is your food - ");
        String food = scanner.nextLine();

        System.out.println("Hii "+name);
        System.out.println("You are "+age+" year old");
        System.out.println("You like "+food);

        scanner.close();
    }
}
// * At the time of enter age it takes \n after it which is for food so that in place of food enter we 
// * take another nextLine ,in place of food nextInt take place of another nextLine