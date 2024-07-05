import java.util.Random;

public class random_no {
    public static void main(String[] args){
    
        Random random = new Random();

        //int x = random.nextInt(6)+1;
        //float x = random.nextFloat();
        //double x = random.nextDouble();
        boolean x = random.nextBoolean();

        System.out.println(x);
    }
}
