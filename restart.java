import java.util.*;

class restart {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter Tower height");
        int n = sc.nextInt();
        // System.out.println(" Enter Tower width");
        // int m = sc.nextInt();
        // int n = 5;
        // int m = 4;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("Sanket is back");
    }
}
