package MixOfAll;

import java.util.Scanner;

public class AB {
    public static void main (String[]args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int []nums = new int[n];
        for(int i =0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        int alicecount = 0,alicetime=0;
        int bobcount = 0,bobtime=0;
        int left =0,right=n-1;
        while(left<=right){
            if(alicetime<=bobtime){
                alicetime+=nums[left];
                left++;
                alicecount++;
            }else {
                bobtime+=nums[right];
                right--;
                bobcount++;
            }
        }
        System.out.println(alicecount+ " " + bobcount);



    }
}
