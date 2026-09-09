package MixOfAll;

import java.util.*;
public class cses {
    public static void fn(long n ){
        if(n==1) return ;
        if(n%2==0){
            n=n/2;
        }else{
            n=(n*3)+1;
        }
        System.out.println(n+" ");
        fn(n);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(n+" ");
        fn(n);

    }
}

