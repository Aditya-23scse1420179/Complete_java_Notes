import java.util.Arrays;
import java.util.Scanner;

public class NumberofPairs {
    static long countPairsAtMost(long[] a, long X) {
        int i = 0, j = a.length - 1;
        long cnt = 0;
        while (i<j){
            if (a[i]+a[j]<=X) {
                cnt+= (j -i);
                i++;
            }else{
                j--;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long L = sc.nextLong();
            long R = sc.nextLong();
            long[]a = new long[n];
            for (int i = 0;i < n;i++)
                a[i] = sc.nextLong();
            Arrays.sort(a);
            long upToR = countPairsAtMost(a, R);
            long belowL = countPairsAtMost(a, L - 1);
            System.out.println(upToR - belowL);
        }
    }
}
