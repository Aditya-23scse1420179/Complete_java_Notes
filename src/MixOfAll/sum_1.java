package MixOfAll;

import java.util.*;

public class sum_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long count = 0, sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > x && left <= right) {
                sum -= arr[left];
                left++;
            }

            if (sum == x) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
