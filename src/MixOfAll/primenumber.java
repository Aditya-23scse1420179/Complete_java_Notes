package MixOfAll;

public class primenumber {
    public static void main(String[] args) {
        System.out.println(isprime(20) );

    }


    public static boolean isprime (int x){
        int res = 0;
        for(int i=1;i<x/2;i++){
            if(x%i==0){
                res++;
            }
        }
        return res == 1;
    }
}
/*public static boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;

    if (n % 2 == 0 || n % 3 == 0) return false;

    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    }
    return true;
}
*/