package HolidayWork;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.*;

public class Apartments {
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int n = fr.nextInt(), m = fr.nextInt(), k = fr.nextInt();
        int[] a = new int[n], b = new int[m];
        for (int i = 0; i < n; i++) a[i] = fr.nextInt();
        for (int j = 0; j < m; j++) b[j] = fr.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        int i =0,j= 0, count = 0;
        while (i <n&&j < m) {
            if (Math.abs(a[i] - b[j]) <= k) {
                count++;i++;j++;
            } else if(b[j]<a[i] -k){
                j++;
            }else{
                i++;
            }
        }
        System.out.println(count);
    }
    static class FastReader {
        private final DataInputStream din = new DataInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int bufferPointer = 0, bytesRead = 0;
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
}
