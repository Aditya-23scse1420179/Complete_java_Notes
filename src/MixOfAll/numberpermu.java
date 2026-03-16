package MixOfAll;

import java.util.ArrayList;
import java.util.List;

class numberpermu {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        helper(nums, ans, curr, used);
        System.out.println(ans);
        return ans;
    }
    public void helper(int[] nums, List<List<Integer>> ans,List<Integer> curr, boolean[] used) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            curr.add(nums[i]);
            used[i] = true;
            helper(nums, ans, curr, used);
            curr.remove(curr.size() - 1); // also we can write curr.removeLast();
            used[i] = false;
        }
    }
}
