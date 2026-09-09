package MixOfAll;

public class IntegerBinary {

    public static void main(String[] args) {
        int n = 37;      // change this
        printBinary(n);
    }
    static void printBinary(int n) {
        if (n == 0) return;   // base case
        printBinary(n / 2);   // go deeper first
        System.out.print(n % 2); // print while coming back up
    }
}
// 2 se divide karo questient nikalo fir questiont ko firse 2 se divide karo jo rem hoga vahi binary hoga