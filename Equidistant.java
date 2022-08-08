import java.io.*;
import java.util.Arrays;
 
 
public class B {
    static StreamTokenizer in;
    static PrintWriter out;
    static int nextInt() throws IOException
    {
        in.nextToken();
        return (int)in.nval;
    }
 
    public static class IntList {
        private int size;
        private int[] arr;
 
        public IntList() {
            size = 0;
            arr = new int[10];
        }
 
        public IntList(int x) {
            size = 0;
            arr = new int[10];
            this.add(x);
        }
 
        public int last() {
            return arr[size - 1];
        }
 
        public void add(int x) {
            if  (arr.length == size) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
            arr[size++] = x;
        }
 
        public int get(int x) {
            return arr[x];
        }
 
        public int size() {
            return size;
        }
    }
 
    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        int n = nextInt();
        int m = nextInt();
        int[] weight = new int[n];
        int[] t = new int[n];
        int[] pr = new int[n];
        int[] u = new int[n];
        IntList[] g = new IntList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new IntList();
        }
        int fin = 0;
        int st = 0;
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt();
            int b = nextInt();
            a--;
            b--;
            g[a].add(b);
            g[b].add(a);
        }
        for (int i = 0; i < m; i++) {
            int x = nextInt();
            x--;
            u[x] = 1;
            t[x] = 1;
            pr[st++] = x;
        }
        while (st != fin) {
            int v = pr[fin++];
            u[v] = 2;
            for (int i = 0; i < g[v].size(); i++) {
                int to = g[v].get(i);
                if (u[to] == 2) continue;
                if (u[to] == 1) {
                    if (weight[to] == weight[v] + 1) t[to] += t[v];
                    continue;
                }
                weight[to] = weight[v] + 1;
                u[to] = 1;
                pr[st++] = to;
                t[to] = t[v];
            }
        }
        for (int i = 0; i < n; i++) {
            if (t[i] == m) {
                System.out.println("YES");
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("NO");
    }
}