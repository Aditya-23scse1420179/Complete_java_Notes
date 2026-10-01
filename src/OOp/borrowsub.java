package OOp;

public class borrowsub {
    public static int countBorrowOperations(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();

        // Agar num1 ki length num2 se chhoti hai, ya length barabar hai par num1 chhota hai
        if (n1 < n2 || (n1 == n2 && num1.compareTo(num2) < 0)) {
            return -1; // Subtraction not possible
        }

        int borrows = 0;
        int carry = 0;

        int i = n1 - 1;
        int j = n2 - 1;

        while (i >= 0) {
            int d1 = num1.charAt(i) - '0' - carry;
            int d2 = (j >= 0) ? (num2.charAt(j) - '0') : 0;

            if (d1 < d2) {
                borrows++;
                carry = 1;
            } else {
                carry = 0;
            }

            i--;
            j--;
        }

        return borrows;
    }

    public static void main(String[] args) {
        System.out.println(countBorrowOperations("58", "49"));   // Output: 1
        System.out.println(countBorrowOperations("1000", "1"));   // Output: 3
        System.out.println(countBorrowOperations("103", "54"));   // Output: 2
        System.out.println(countBorrowOperations("49", "58"));   // Output: -1
    }
}
