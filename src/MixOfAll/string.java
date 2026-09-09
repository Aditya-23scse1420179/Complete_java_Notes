package MixOfAll;

public class string {
    public static void main (String [] args){
        String s1 ="hello World";
        String s2 = s1.toUpperCase();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.length());      // to check length
        System.out.println(s1.charAt(0));     // to check character at desired index starting from 0
        System.out.println(s1.substring(0,6));   // if want to returnsub MixOfAll.string from starting to ending index
        System.out.println(s1.contains("World")); // to check weather MixOfAll.string contain desiered search or not
        System.out.println(s1.replace("World","Java"));
    }
}
//operation in MixOfAll.string