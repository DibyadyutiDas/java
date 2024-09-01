import java.io.*;

public class file_reader {
    public static void main(String[] args) {
        
        try {
            FileReader reader = new FileReader("file.txt");
            int data = reader.read();
            while (data != -1) {
                System.out.print((char)data);
                data = reader.read();
            }
            reader.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.fillInStackTrace();
        } 
        // catch (FileNotFoundException e) {
        //     // TODO: handle exception
        //     e.fillInStackTrace();
        // }
    }
}
