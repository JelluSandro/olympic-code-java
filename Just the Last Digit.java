import java.util.*;
import static java.lang.Math.*;
 
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int)s.charAt(j) - (int)'0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i][j] == 0) { continue;}
                for (int k = j + 1; k < n; k++) {
                    arr[i][k] -= arr[j][k];
                    if (arr[i][k] < 0) {
                        arr[i][k] += 10;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}