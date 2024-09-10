import java.io.*;

class multithread extends thread {

    public void start()
    {
        System.out.println("Thread name is : " + Thread.currentThread().getName());
        System.out.println("Thread priority is : " + Thread.currentThread().getPriority());
    }
}

public class thread {
    public static void main(String[] args) {
        
        multithread thread1 = new multithread();
        multithread thread2 = new multithread();
        multithread thread3 = new multithread();

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
