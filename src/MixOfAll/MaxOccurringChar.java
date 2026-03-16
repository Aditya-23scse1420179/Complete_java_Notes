package MixOfAll;

/*class MaxOccurringChar {
    public static int helper(String s) {
        int[] freq = new int[26]; // only lowercase assumed
        // count frequencies
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        // find max frequency
        int max = 0;
        for (int f : freq) {
            max = Math.max(max, f);
        }
        return max;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "leetcode";
        System.out.println(helper(s)); // output: 3
    }
}*/
import java.util.HashMap;
import java.util.*;
class MaxOccuringChar {
    public static int helper(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int max = 0;
        for (int freq : map.values()) {
            max = Math.max(max, freq);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "goodmorning";
        System.out.println(helper(s));//output:3
    }
}
/*
if have to print that char also
import java.util.HashMap;

class MaxOccuringChar {
    public static void helper(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = 0;
        char maxChar = ' ';
        for (char c : map.keySet()) {
            if (map.get(c) > max) {
                max = map.get(c);
                maxChar = c;
            }
        }
        System.out.println("Most frequent char: " + maxChar);
        System.out.println("Frequency: " + max);
    }
    public static void main(String[] args) {
        String s = "goodmorning";
        helper(s);
    }
}
*/
/*
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    String s="goodmorning";
		System.out.println(helper(s));
	}
	public static HashMap<Character,Integer> helper(String s){
	    HashMap<Character,Integer>map=new HashMap<>();
	    for(char c:s.toCharArray()){
	        map.put(c,map.getOrDefault(c,0)+1);
	    }return map;
	}
}
*/ //all character with freq
/* print in general form
import java.util.*;

class Solution {
    public static void printAllFreq(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> e : map.entrySet()){
            System.out.println(e.getKey() +  e.getValue());
        }
    }
    public static void main(String[] args){
        printAllFreq("goodmorning");
    }
}

 */