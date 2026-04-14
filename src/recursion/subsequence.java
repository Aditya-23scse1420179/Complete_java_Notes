package recursion;

public class subsequence{
    public static boolean printSubsequence(String str,int s,int sum, int index, String curr){
        if(index == str.length()){
            if(s==sum){
                System.out.println(curr);
                return true;
            }
            return false;
        }
        // Include the character at the current index
        if(printSubsequence(str, s,sum,index + 1, curr + str.charAt(index))){
            return true;
        };
        // Exclude the character at the current index
        return printSubsequence(str, s, sum, index + 1, curr);
    }

    public static void main(String[] args) {
        String str = "abcde";
        int sum =2;
        printSubsequence(str, 0, sum, 0, "");
    }
}
