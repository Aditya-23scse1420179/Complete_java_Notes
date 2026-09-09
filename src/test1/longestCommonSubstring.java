package test1;

public class longestCommonSubstring {
    int longestCommonSubstr(String s1, String s2){
        int n=s1.length();
        int m=s2.length();
        return solve(s1,s2,n,m,0);
    }
    int solve(String s1,String s2,int i,int j,int count) {
        if (i == 0||j ==0)
            return count;
        int currCount =count;
        if (s1.charAt(i-1)==s2.charAt(j -1)){
            currCount = solve(s1, s2,i -1,j -1,count +1);
        }
        int skipS1 =solve(s1,s2,i-1,j,0);
        int skipS2 =solve(s1,s2,i,j-1,0);
        return Math.max(currCount, Math.max(skipS1, skipS2));
    }
    public static void main(String[] args){
        longestCommonSubstring obj =new longestCommonSubstring();
        String s1 ="abcdxyz";
        String s2 ="xyzabcd";
        int result =obj.longestCommonSubstr(s1,s2);
        System.out.println(result);
    }
}
