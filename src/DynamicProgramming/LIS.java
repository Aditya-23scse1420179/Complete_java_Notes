package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class LIS {// print longest increasing subsequence
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n=arr.length;
        int []dp= new int [n];
        int[]parent= new int [n];
        Arrays.fill(dp,1);
        Arrays.fill(parent,-1);
        int maxi=0;
        for(int curr=1;curr<n;curr++){
            for(int prev=0;prev<curr;prev++){
                if(arr[curr]>arr[prev]&&dp[prev]+1>dp[curr]){
                    dp[curr]=dp[prev]+1;
                    parent[curr]=prev;
                }
            }
            if(dp[curr]>maxi) {
                maxi = curr;
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=maxi;i!=-1;i=parent[i]){
            ans.add(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}

