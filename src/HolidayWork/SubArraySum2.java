package HolidayWork;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SubArraySum2 {
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
    public static void main (String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(helper(arr, k));
    }
    public static long helper(long[] arr, long k){
        long prefix = 0;
        long count = 0;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);   // prefix 0 ek baar dikha
        for(long x : arr){
            prefix += x;
            long need = prefix - k;
            if(map.containsKey(need)){
                count += map.get(need);
            }
            map.put(prefix, map.getOrDefault(prefix, 0L) + 1);
        }
        return count;
    }
}

