package HolidayWork;

import java.util.*;

class AllCombinations {
    static TreeSet<String> result;
    static void permute(String s,String built) {
        if (s.isEmpty()){
            result.add(built);
            return;
        }
        for (int i =0;i <s.length();i++) {
            permute(s.substring(0,i) +s.substring(i+1),built+s.charAt(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input =sc.next();
        result =new TreeSet<>();
        permute(input,"");
        System.out.println(result.size());
        for (String s:result) {
            System.out.println(s);
        }
    }
}
