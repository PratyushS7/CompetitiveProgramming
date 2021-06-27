import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.io.IOException;
import java.util.ArrayList;
import java.io.UncheckedIOException;
import java.util.List;
import java.io.Closeable;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;
 
/**
 * @author khokharnikunj8
 */
public class edu109 {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(null, new TaskAdapter(), "khokharnikunj8", 1 << 29);
        thread.start();
        thread.join();
    }
 
    static class TaskAdapter implements Runnable {
        @Override
        public void run() {
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            FastInput in = new FastInput(inputStream);
            FastOutput out = new FastOutput(outputStream);
            DArmchairs solver = new DArmchairs();
            solver.solve(1, in, out);
            out.close();
        }
    }
 
    static class DArmchairs {
        public void solve(int testNumber, FastInput in, FastOutput out) {
            int n = in.readInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) ar[i] = in.readInt();
            List<Integer> ls1 = new ArrayList<>();
            List<Integer> ls0 = new ArrayList<>();
            for (int i = 0; i < n; i++)
                if (ar[i] == 1) {
                    ls1.add(i);
                } else {
                    ls0.add(i);
                }
            int one = ls1.size();
            int zero = ls0.size();
            if (one == 0) {
                out.println(0);
                return;
            }
            int[][] dp = new int[one + 1][zero + 1];
            for (int i = 0; i <= one; i++) Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            Arrays.fill(dp[0], 0);
 
            for (int i = 1; i <= one; i++) {
                for (int j = 1; j <= zero; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + Math.abs(ls1.get(i - 1) - ls0.get(j - 1)));
                }
            }
 
            out.println(dp[one][zero]);
 
        }
 
    }
 
    static class FastInput {
        private final InputStream is;
        private final byte[] buf = new byte[1 << 13];
        private int bufLen;
        private int bufOffset;
        private int next;
 
        public FastInput(InputStream is) {
            this.is = is;
        }
 
        private int read() {
            while (bufLen == bufOffset) {
                bufOffset = 0;
                try {
                    bufLen = is.read(buf);
                } catch (IOException e) {
                    bufLen = -1;
                }
                if (bufLen == -1) {
                    return -1;
                }
            }
            return buf[bufOffset++];
        }
 
        public void skipBlank() {
            while (next >= 0 && next <= 32) {
                next = read();
            }
        }
 
        public int readInt() {
            int sign = 1;
 
            skipBlank();
            if (next == '+' || next == '-') {
                sign = next == '+' ? 1 : -1;
                next = read();
            }
 
            int val = 0;
            if (sign == 1) {
                while (next >= '0' && next <= '9') {
                    val = val * 10 + next - '0';
                    next = read();
                }
            } else {
                while (next >= '0' && next <= '9') {
                    val = val * 10 - next + '0';
                    next = read();
                }
            }
 
            return val;
        }
 
    }
 
    static class FastOutput implements AutoCloseable, Closeable, Appendable {
        private final Writer os;
        private final StringBuilder cache = new StringBuilder(5 << 20);
 
        public FastOutput(Writer os) {
            this.os = os;
        }
 
        public FastOutput(OutputStream os) {
            this(new OutputStreamWriter(os));
        }
 
        public FastOutput append(CharSequence csq) {
            cache.append(csq);
            return this;
        }
 
        public FastOutput append(CharSequence csq, int start, int end) {
            cache.append(csq, start, end);
            return this;
        }
 
        public FastOutput append(char c) {
            cache.append(c);
            return this;
        }
 
        public FastOutput append(int c) {
            cache.append(c);
            return this;
        }
 
        public FastOutput println(int c) {
            return append(c).println();
        }
 
        public FastOutput println() {
            cache.append(System.lineSeparator());
            return this;
        }
 
        public FastOutput flush() {
            try {
                os.append(cache);
                os.flush();
                cache.setLength(0);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
            return this;
        }
 
        public void close() {
            flush();
            try {
                os.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
 
        public String toString() {
            return cache.toString();
        }
 
    }
}