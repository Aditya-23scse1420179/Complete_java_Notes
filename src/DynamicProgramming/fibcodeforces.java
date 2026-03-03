package DynamicProgramming;
import java.util.Scanner;

public class fibcodeforces {
    static int count = 0;
    public static void helper(int prev2,int prev1, int steps) {
        while (steps> 0) {
            int curr= prev2 - prev1;
            if (curr< 0) return;
            if (curr> prev1) return;
            prev2 = prev1;
            prev1 =curr;

            steps--;
        }
        count++;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int size =sc.nextInt();
        int[][] maxtrix = new int[size][2];
        for(int i=0; i<size;i++){
            maxtrix[i][0]= sc.nextInt();   // n
            maxtrix[i][1] =sc.nextInt();   // k
        }
        for(int i=0;i<maxtrix.length;i++){
            int n =maxtrix[i][0];
            int k =maxtrix[i][1];
            for(int j =n;j>= 0;j--){
                helper(n, j, k -2);
            }
            System.out.println(count);
            count = 0;
        }
    }
}