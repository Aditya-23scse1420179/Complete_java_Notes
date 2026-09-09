package MixOfAll;

import java.util.*;
class subsequences {
    static boolean flag = false;// to print only one subsequence
    public static void  subseq(int idx, int []arr,int sum,ArrayList<Integer>temp,int s){
        int n = arr.length;
        if(idx==n){
            if(s==sum&& !flag){
                flag=true;// to print only one subsequence
                System.out.print(temp);// print the subsequence
            }
            return;
        }
        temp.add(arr[idx]);
        s+=arr[idx];
        subseq(idx+1,arr,sum,temp,s);
        temp.removeLast();
        s-=arr[idx];
        subseq(idx+1,arr,sum,temp,s);
    }
    public static void main (String[]args){
        int []arr ={1,2,3,4,5,6};
        int sum =4;
        subseq(0,arr,sum,new ArrayList<>(),0);
    }
}