package test1;

public class sumEqualTarget {
    public static int helper(int[] arr,int target, int i,Integer[][]dp){
        if (target ==0)return 1;
        if (i == arr.length||target <0) return 0;
        if (dp[i][target] != null)return dp[i][target];
        int include = helper(arr,target-arr[i],i +1,dp);
        int exclude = helper(arr,target, i+1,dp);
        dp[i][target] =include+exclude;
        return dp[i][target];
    }
    public static void main(String[] args){
        int[] arr = {5,2,3,10,6,8};
        int target =10;
        Integer[][] dp =new Integer[arr.length][target +1];
        int result =helper(arr,target, 0,dp);
        System.out.println(result);
    }
}
