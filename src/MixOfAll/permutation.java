package MixOfAll;

import java.util.ArrayList;
import java.util.List;

public class permutation{
    public static void main(String[]args){
        String str ="abc";
        List<String> ans = new ArrayList<>();
        helper(str,"",ans);
        System.out.println(ans);
    }
    private static void helper(String str, String curr,List<String>ans ){
        if("".equals(str)){
            ans.add(curr);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            String left =str.substring(0,i);
            String right = str.substring(i+1);
            String comb = left+right;
            helper(comb,curr+ch,ans);
        }
    }
}