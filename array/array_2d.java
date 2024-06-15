public class array_2d {
    public static void main(String[] args){
    
        String cars[][] =   { 
                                {"Camaro","Corvette","Silverado"},
                                {"Mustang","Ranger","F-150"},
                                {"Ferrari","Lamborghini","Tesla"}
                            };

        String car[][] = new String[3][3];

        car[0][0] = "Camaro";
        car[0][1] = "Corvette";
        car[0][2] = "Silverado";
        car[1][0] = "Mustang";
        car[1][1] = "Ranger";
        car[1][2] = "F-150";
        car[2][0] = "Ferrari";
        car[2][1] = "Lamborghini";
        car[2][2] = "Tesla";

        for (int i = 0; i < car.length; i++) {
            System.out.println("");
            for (int j = 0; j < car[i].length; j++) {
                System.out.print(car[i][j]+" ");
            }
        }

        System.out.println("");

        for (int i = 0; i < cars.length; i++) {
            System.out.println("");
            for (int j = 0; j < cars[i].length; j++) {
                System.out.print(cars[i][j]+" ");
            }
        }
    }
}