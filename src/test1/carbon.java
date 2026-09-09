package test1;

import java.util.*;
public class carbon {
    public static void main(String[] args) {
        int[] arr = {31,26,33,21,40};
        Arrays.sort(arr);
        int n =arr.length;
        while (n >1) {
            int diff =Math.abs(arr[n -1] -arr[n -2]);
            arr[n- 2] =diff;
            n--;
            Arrays.sort(arr,0, n);
        }
        System.out.println(arr[0]);
    }
}

