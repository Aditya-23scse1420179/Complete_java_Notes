package MixOfAll;

import java.util.Random;

public class otpGenerator {
    public static void main(String[]args){
        Random random = new Random();
        String OTP="";
        for(int i=0;i<4;i++){
            int digit = random.nextInt(10);
            OTP += digit;
        }
        System.out.println("Your OTP is: " + OTP);
    }
}
