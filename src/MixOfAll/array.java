package MixOfAll;

import java.util.*;
public class array {
    public static void main (String []args){
       // int a [] = new int [5];     use if you have to assign simple empty MixOfAll.array of size 5
        int [] a ={1,2,3,4,5,6};
        int sum = 0;
        for(int i=0;i<=5;i++){
            System.out.println(a[i]);
        }
        for (int i:a) {
            System.out.println(i);
        }  // for each loop in this i is treated as an element and index both in MixOfAll.array a


        for ( int i :a) {
            if (i == 50)
                System.out.println("found");
            else
                System.out.println("not found");
        }

        for ( int i =0;i<a.length;i++){ //to print sum of all elements
            sum += a[i];


        }
        System.out.println(sum);

    }
}
// reverse iterative

class main {
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the elements:");
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=n-1;i>=0;i--){
            System.out.print(arr[i]+" ");
        }
    }
}
// using recursive approch
class mmain{
    public static void print(int arr[],int lastIdx){
        if(lastIdx<0)return;
        System.out.print(arr[lastIdx]+" ");
        print(arr,lastIdx-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the elements:");
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        print(arr,arr.length-1);
    }
}