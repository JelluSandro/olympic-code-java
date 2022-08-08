import java.util.*;
import static java.lang.Math.*;
 
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int ii =0; ii < t; ii++) {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            int[] a = new int[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = n - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    ans += map.getOrDefault((2 * a[i] - a[j]), 0);
                }
                map.merge(a[i], 1, Integer::sum);
            }
            System.out.println(ans);
        }
    }
}