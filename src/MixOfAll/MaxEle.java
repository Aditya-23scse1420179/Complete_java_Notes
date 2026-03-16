package MixOfAll;


public class MaxEle {
    public static int[] Arrayssort(int []arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[]args){
        int[]arr={23,45,67,89,12,90,34,56};
        int []arr2={12,34,56,78,100,11,22,33};
        Arrayssort(arr);
        Arrayssort(arr2);
        if(arr[arr.length-1]>arr2[arr2.length-1]){
            System.out.println(arr[arr.length-1]);
        }else{
            System.out.println(arr2[arr2.length-1]);
        }
    }

}
