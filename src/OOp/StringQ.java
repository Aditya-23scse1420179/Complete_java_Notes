package OOp;

public class StringQ {
    public static void main(String[]args){
        String s="Move#to#end";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                sb.append("#");
            }
        }
        for(int j=0;j<sb.length();j++){
            if(sb.charAt(j)=='#')continue;
            else 
            sb.append(s.charAt(j));
        }
        System.out.println(sb.toString());
    }
}
