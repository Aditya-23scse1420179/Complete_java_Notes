package stack;

import java.util.*;
class reverseStack{
    static void insertAtBottom(Stack<Integer>st,int x){
        if(st.isEmpty()){//||st.peek()<=x add line after empty() to make this same code for sorting in stack
            st.push(x);
            return;
        }
        int top=st.pop();
        insertAtBottom(st,x);
        st.push(top);
    }
    static void reverse(Stack<Integer>st){
        if(st.isEmpty())return;
        int top=st.pop();
        reverse(st);
        insertAtBottom(st,top);
    }
    public static void main(String[]args){
        Stack<Integer>st=new Stack <>();
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(8);
        reverse(st);
        System.out.print(st);

    }

}