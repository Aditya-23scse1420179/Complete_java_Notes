package MixOfAll;

public class dominantcount {
    public static void main(String[] args){
        int[]nums={5,4,3};
        System.out.println(dominantIndices(nums));
    }public static int dominantIndices(int[] nums) {
        long total=0;
        for(int x:nums){
            total+=x;
        }long lsum=0;
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            lsum+=nums[i];
            long rsum=total-lsum;
            int rcount=nums.length-i-1;
            double avg=(double)rsum/rcount;
            if(nums[i]>avg){
                count++;
            }
        }
        return count;
    }

}
