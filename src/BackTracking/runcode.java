package BackTracking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*public class runcode {//run code fast on leetcode
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt");
                fw.write("000");
                fw.close();
            } catch (Exception e) {}
        }));
    }
}*/

import java.util.*;

public class runcode {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter command: ");
        String n = sc.nextLine();

        if (n.equals("hack nasa")) {
            System.out.println("Access Granted");
            Thread.sleep(2000);

            System.out.println("Hacked 10% of NASA files");
            Thread.sleep(2000);

            System.out.println("Hacked 50% of NASA files");
            Thread.sleep(2000);

            System.out.println("Hacked 90% of NASA files");
            Thread.sleep(2000);

            System.out.println("Hacked 100% of NASA files");
            Thread.sleep(2000);

            System.out.println("Hack successful 💀🚀");
        } else {
            System.out.println("Access Denied ❌");
        }
    }
}


