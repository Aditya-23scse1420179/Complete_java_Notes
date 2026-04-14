package MixOfAll;

import java.util.*;

public class sum_2cses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long x = sc.nextLong();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        HashMap<Long, Long> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1L); // base case

        long prefixSum = 0;
        long count = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // check if (prefixSum - x) exists
            if (prefixCount.containsKey(prefixSum - x)) {
                count += prefixCount.get(prefixSum - x);
            }

            // update map with current prefixSum
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0L) + 1);
        }

        System.out.println(count);
        sc.close();
    }
}
