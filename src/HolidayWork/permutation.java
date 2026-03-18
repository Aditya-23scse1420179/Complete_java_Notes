package HolidayWork;

import java.util.*;

public class permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer,Queue<Integer>>pos = new HashMap<>();
        int[] a =new int[n];
        for (int i =0;i <n;i++) {
            a[i] =sc.nextInt();
            pos.computeIfAbsent(a[i], k -> new LinkedList<>()).add(i);
        }
        int[] ans =new int[n];
        int permId =0;
        while (true){
            permId++;
            int need =1;
            while (true){
                Queue<Integer>q = pos.get(need);
                if (q ==null||q.isEmpty()) {
                    break;
                }
                ans[q.poll()] =permId;
                need++;
            }
            if (need ==1){
                permId--;
                break;
            }
        }
        for (int x :ans) {
            if (x ==0){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(permId);
        for (int x : ans) System.out.print(x + " ");
    }
}
