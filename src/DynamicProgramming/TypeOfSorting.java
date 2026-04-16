package DynamicProgramming;

import java.util.Arrays;

public class TypeOfSorting {
    public static void main(String[]args) {
        int[][] arr = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        //Arrays.sort(arr,(a, b)->a[0]-b[0]); sirf col 0 ke basis pe sort kar dega comma k epahle waale digit ke basis pe
        //Arrays.sort(arr,(a,b)->b[0]-a[1]);//ye 1 aur 2 dono ke bais spe desc kar raha
        /*Arrays.sort(arr,(a,b)->{
            if(a[1]!=b[1])return a[1]-b[1];
            return a[0]-b[0];
        });*/
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            return a[1]-b[1];
        });// sprt bases on first row then col
        for(int[]x:arr){
            System.out.println(Arrays.toString(x));
        }

    }
}
