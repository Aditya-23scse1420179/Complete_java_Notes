package MixOfAll;

import java.util.*;

public class pokemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        // Step 1: Find number of unique chars in s
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);
        int need = set.size(); // how many distinct chars we need

        // Step 2: Sliding window
        int left = 0, formed = 0, minLen = n;
        Map<Character, Integer> window = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Count formed only when char freq becomes 1
            if (window.get(c) == 1) {
                formed++;
            }

            // Step 3: Try shrinking window if it covers all unique chars
            while (formed == need) {
                minLen = Math.min(minLen, right - left + 1);

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (window.get(leftChar) == 0) {
                    window.remove(leftChar);
                    formed--;
                }
                left++;
            }
        }

        System.out.println(minLen);
    }
}
