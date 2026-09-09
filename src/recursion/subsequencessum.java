package recursion;

import java.util.ArrayList;
import java.util.List;

public class subsequencessum {
    public void findcombinations(int idx, int[]arr, int target, List<List<Integer>>ans , List<Integer> ds){
        if(idx==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        //take
        if(arr[idx]<=target){
            ds.add(arr[idx]);
            findcombinations(idx, arr, target-arr[idx], ans, ds);
            ds.remove(ds.size()-1);
        }
        //not take
        findcombinations(idx+1, arr, target, ans, ds);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findcombinations(0, candidates, target, ans, ds);
        return ans;
    }
}
