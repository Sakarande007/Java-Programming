
public class day3 {
    public static void main(String[] args) {
        // if and Else statement
        /*
         * int x = 12;
         * int y = 15;
         * int z = 2;
         * 
         * if (x > y && x > z) {
         * System.out.println(x);
         * } else if (y > z && y > x) {
         * System.out.println(y);
         * } else {
         * System.out.println(z);
         * 
         * }
         */

        // Ternary Operator

        /*
         * int n = 7;
         * int result = 0;
         * 
         * result = n % 2 == 0 ? 10 : 20;
         * 
         * System.out.println(result);
         * 
         * System.out.println("Sanket");
         */

        // Switch

        int n = 8;

        switch (n) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Enter Number Between 1 to 7");
        }
    }
}