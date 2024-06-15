public class array {
    public static void main(String[] args){
    
        // array = used to store multiple value in one variable

        String[] car = new String[3];
        String[] bike = {"hero","honda","tvs"};
        bike[0] = "Royal_infilled";

        car[0] = "Camaro";
        car[1] = "Corvette";
        car[2] = "Tesla";

        for (int i = 0; i < car.length; i++) {
            System.out.println(car[i]);
        }
        for (int i = 0; i < bike.length; i++) {
            System.out.println(bike[i]);
        }
    }
}
