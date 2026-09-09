package recursion;

public class SubfromString {
    public static String fn(String s){
        StringBuilder sb = new StringBuilder(s);
        for(int i = sb.length() - 1; i >= 0; i--){
            int a = sb.charAt(i) - '0';
            if(a == 0){
                sb.setCharAt(i, '9');// borrow from next digit
                continue;
            }
            if(a == 1 && i == 0){
                break;// to handle case like 1000 -> 999
            } else {
                sb.setCharAt(i, (char)('0' + (a - 1)));
                return sb.toString();
            }
        }
        return sb.substring(1);// in case of leading zero after subtraction
    }
    public static void main(String[] args){
        String s = "1000";
        String ans = fn(s);
        System.out.println(ans);
    }
}
