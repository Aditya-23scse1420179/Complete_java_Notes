package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sumEqualtarget {
    public static void helper(int index, int target, int []arr, List<List<Integer>>ans, List<Integer>ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index; i<arr.length; i++){
            if(i>index&&arr[i]==arr[i-1])continue;
            if(arr[i]>target)break;
            ds.add(arr[i]);
            helper(i+1,target-arr[i],arr,ans,ds);
            ds.remove(ds.size()-1);
        }
    }

    public static void main (String[]args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(0, target, arr, ans, ds);
        //System.out.println(helper(ans);
    }
}