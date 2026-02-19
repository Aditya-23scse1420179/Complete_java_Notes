package MixOfAll;

import java.util.Scanner;

public class book {
    public static void main (String[]args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int []nums = new int [n];
        for(int i =0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int total =0;
        int maxlen=0;
        int left=0;
        int right =0;
        while(right<nums.length){
            total +=nums[right];
            while(total>k){
                total = total - nums[left];
                left++;

            }
            maxlen = Math.max(maxlen,right-left+1);
            right++;



        }
        System.out.println(maxlen);
    }
}
