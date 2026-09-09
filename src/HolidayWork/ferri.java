package HolidayWork;
import java.io.*;
import java.util.*;

public class ferri {
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
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int x = fr.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = fr.nextInt();
        }
        Arrays.sort(w);
        int i = 0,j =n - 1;
        int gondolas = 0;
        while (i <= j){
            if (w[i]+w[j] <= x) {
                i++;
            }
            j--;
            gondolas++;
        }
        System.out.println(gondolas);
    }
}
