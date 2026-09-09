package HolidayWork;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class RangeSum {
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
    public static void main(String[]args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] arr = new long[n+1];
        for (int i = 1; i <=n; i++) arr[i] =arr[i-1]+ sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append(arr[b]-arr[a-1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
