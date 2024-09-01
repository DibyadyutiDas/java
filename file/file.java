import java.io.*;

public class file {
    public static void main(String[] args) {
        
        File file = new File("file.txt");

        if (file.exists()) {
            System.out.println("File exist");
            System.out.println(file.getAbsolutePath());
            file.delete();
        } else {
            System.out.println("File not exist");
        }
    }
}
