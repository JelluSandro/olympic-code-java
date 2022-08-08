import java.util.*;
 
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = -25000 * 710;
        for (; n > 0; n--) {
            System.out.println(x);
            x += 710;
        }
    }
}