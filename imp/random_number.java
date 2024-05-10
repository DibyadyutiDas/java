// ?WAP to give a random number

import java.util.Random;
public class random_number {
        public static void main(String[] args) {
            Random random = new Random();
    
            // Generate a random integer
            int randomInt = random.nextInt();
            System.out.println("Random Integer: " + randomInt);
    
            // Generate a random integer within a range (e.g., 0 to 99)
            int randomIntInRange = random.nextInt(100); // 0 to 99
            System.out.println("Random Integer between 0 and 99: " + randomIntInRange);
    
            // Generate a random double between 0.0 and 1.0
            double randomDouble = random.nextDouble();
            System.out.println("Random Double: " + randomDouble);
    
            // Generate a random boolean
            boolean randomBoolean = random.nextBoolean();
            System.out.println("Random Boolean: " + randomBoolean);
        }
    }
    

    // public class MathRandomExample {
    //     public static void main(String[] args) {
    //         // Generate a random double between 0.0 and 1.0
    //         double randomDouble = Math.random();
    //         System.out.println("Random Double: " + randomDouble);
    
    //         // Generate a random integer within a range (e.g., 0 to 99)
    //         int randomIntInRange = (int) (Math.random() * 100); // 0 to 99
    //         System.out.println("Random Integer between 0 and 99: " + randomIntInRange);
    
    //         // Generate a random integer within a specific range (e.g., min to max)
    //         int min = 50;
    //         int max = 150;
    //         int randomIntInSpecificRange = (int) (Math.random() * (max - min + 1)) + min; // min to max
    //         System.out.println("Random Integer between " + min + " and " + max + ": " + randomIntInSpecificRange);
    //     }
    // }