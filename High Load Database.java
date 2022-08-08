import java.util.*;
import java.io.*;
import static java.lang.Math.max;
 
 
public class B {
    static final int mm = (int)1e6 + 7;
    static int[] ot = new int[mm];
    static PrintWriter out;
    static StreamTokenizer in;
    static int nextInt() throws IOException
    {
        in.nextToken();
        return (int)in.nval;
    }
    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        int mx = a[0];
        for (int i = 1; i < n; i++) {
            mx = max(a[i], mx);
            a[i] += a[i - 1];
        }
        int q = nextInt();
        int cnt = 0, j = 0, ans = 0, l = 0, r = n;
        out = new PrintWriter(System.out);
        for (int ii = 0; ii < q; ii++) {
            int t = nextInt();
            if (t < mx) {
                System.out.println("Impossible");
                continue;
            }
            if (ot[t] != 0) {
                System.out.println(ot[t]);
                continue;
            }
            cnt = 0; j = 0; ans = 0; l = 0; r = n;
            for (; j < n; ans++, j = r, cnt = a[l]) {
                l = j;
                r = n;
                while(r > l + 1) {
                    int m = l + (r - l) / 2;
                    if (a[m] <= cnt + t) {
                        l = m;
                    } else {
                        r = m;
                    }
                }
            }
            ot[t] = ans;
            System.out.println(ans);
        }
    }
}