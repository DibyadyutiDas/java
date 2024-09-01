import java.io.*;

public class file_writer {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("file.txt");
            writer.write("hello world");
            writer.append("\n          (create by  Dibyadyuti)");
            writer.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
