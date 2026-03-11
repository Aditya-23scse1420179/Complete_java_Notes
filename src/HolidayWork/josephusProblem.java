package HolidayWork;

import java.util.*;

public class josephusProblem {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        Stack<Integer> s1 =new Stack<>();
        Stack<Integer>s2 =new Stack<>();
        for(int i =n;i>=1;i--){
            s1.push(i);
        }
        boolean remove = false;
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(s1.isEmpty()){
                while(!s2.isEmpty())
                    s1.push(s2.pop());
            }
            if(remove){
                System.out.print(s1.pop() + " ");
            }else{
                s2.push(s1.pop());
            }
            remove = !remove;
        }
    }
}
