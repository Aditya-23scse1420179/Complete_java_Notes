package MixOfAll;

public class cutRope {
    public int maxPieces(int n, int a, int b, int c) {
        if (n==0) return 0;
        if (n<0) return-1;
        int result = Math.max(
                Math.max(maxPieces(n -a,a,b,c),
                        maxPieces(n - b,a,b,c)),
                maxPieces(n -c,a,b,c)
        );
        if(result==-1) return-1;
        return result+1;
    }
    public static void main(String[] args) {
        cutRope obj =new cutRope();
        int n=5, a=2, b=5, c=1;
        System.out.println(obj.maxPieces(n,a,b,c));
    }
}
