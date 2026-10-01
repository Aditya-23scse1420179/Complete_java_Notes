package DynamicProgramming;

public class LisSum {
    public static void main(String[] args){
        int[]arr={10,20,30,25,15,5,20};
        System.out.println(helper(arr));
    }public static int helper(int[]arr){
        int n=arr.length;
        int[]dp1=new int[n];
        int[]dp2=new int[n];

        for(int i=0;i<n;i++){
            dp1[i]=arr[i];
            dp2[i]=arr[i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp1[i]=Math.max(dp1[i],dp1[j]+arr[i]);
                }
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j]){
                    dp2[i]=Math.max(dp2[i],dp2[j]+arr[i]);
                }
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            if(dp1[i]>arr[i]&&dp2[i]>arr[i]){
                sum=Math.max(sum,dp1[i]+dp2[i]-arr[i]);
            }
        }
        return sum;
    }
}
