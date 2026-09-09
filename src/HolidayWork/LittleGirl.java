package HolidayWork;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class LittleGirl {
    static class FastScanner {
        private final DataInputStream din = new DataInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private final InputStream in;
        private int bufferPointer = 0, bytesRead = 0;

        public FastScanner(InputStream in) {
            this.in=in;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c >= '0' && c <= '9');
            return neg ? -ret : ret;
        }
        private byte read() throws IOException {
            if (bytesRead == -1) throw new EOFException();
            if (bufferPointer >= bytesRead) {
                bufferPointer = 0;
                bytesRead = din.read(buffer);
                if (bytesRead <= 0) return -1;
            }
            return buffer[bufferPointer++];
        }
    }
    public static void main(String[]args)throws Exception{
        FastScanner sc=new FastScanner (System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();
        long []a=new long[n];
        for (int i =0;i < n;i++) a[i]=sc.nextInt();
        long[] diff = new long[n+3];
        while (m--> 0) {
            int l=sc.nextInt();
            int r=sc.nextInt();
            diff[l]+=1;
            diff[r+1]-= 1;
        }
        long[]freq = new long[n];
        long cur =0;
        for (int i =1;i<=n;i++) {
            cur+=diff[i];
            freq[i-1] =cur;
        }
        Arrays.sort(a);
        Arrays.sort(freq);
        long ans = 0;
        for (int i=0;i <n;i++) {
            ans +=a[i] *freq[i];
        }
        System.out.println(ans);
    }
}
