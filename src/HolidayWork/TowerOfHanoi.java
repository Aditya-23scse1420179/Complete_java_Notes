package HolidayWork;
import java.util.*;
class TowerOfHanoi {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //long moves = (long)Math.pow(2, n) - 1;
        hanoi(n,1,3,2);
    }
    static void hanoi(int n,int source,int dest,int helper) {
        if(n==0)return;
        // move n-1 disks from source to helper
        hanoi(n-1,source,helper,dest);
        // move nth disk from source to dest
        System.out.println(source+" " +dest);
        // move n-1 disks from helper to dest
        hanoi(n-1,helper,dest,source);
    }
}
