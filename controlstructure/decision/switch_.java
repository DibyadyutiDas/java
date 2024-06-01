// ?WAP using switch case

public class switch_ {
    public static void main(String[] args){

        String day = "Friday";

        switch (day) {
            case "Sunday":
            System.out.println("This is Sunday");
                break;
                
            case "Monday":
            System.out.println("This is Monday");
                break;
                
            case "Tuesday":
            System.out.println("This is Tuesday");
                break;
                
            case "Wednesday":
            System.out.println("This is Wednesday");
                break;
                
            case "Thursday":
            System.out.println("This is Thursday");
                break;
        
            case "Friday":
            System.out.println("This is Friday");
                break;
                
            case "Saturday":
            System.out.println("This is Saturday");
                break;
            default:
            System.out.println("This is not a day");
                break;
        }
    }
}