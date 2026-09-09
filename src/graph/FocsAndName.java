package graph;

import java.util.*;

public class FocsAndName {
    public static void main(String[]args) {
        // code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[]words=new String[n];
        for(int i=0;i<n;i++){
            words[i]=sc.next();
        }ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int[]indegree=new int[26];
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<26;i++){
            list.add(new ArrayList<>());
        }for(int i=0;i<words.length-1;i++){
            String w1=words[i];
            String w2=words[i+1];
            if(w1.length()>w2.length()&&w1.startsWith(w2)){
                System.out.println("Impossible");
                return;
            }
            for(int k=0;k<Math.min(w1.length(),w2.length());k++){
                char wo1=w1.charAt(k);
                char wo2=w2.charAt(k);
                if(wo1!=wo2){
                    list.get(wo1-'a').add(wo2-'a');
                    indegree[wo2-'a']++;
                    break;
                }
            }
        }for(int i=0;i<26;i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            sb.append((char)(curr+'a'));
            for(int a:list.get(curr)){
                indegree[a]--;
                q.offer(a);
            }
        }int count=0;
        for(int i=0;i<26;i++){
            if(indegree[i]>0){
                count++;
            }
        }
        System.out.println((count==0)?sb.toString():"Impossible");
    }
}
