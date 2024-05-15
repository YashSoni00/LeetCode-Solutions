package Medium;

public class Pow_X_N {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2147483648)); // 0.00000 expected but 1.0 returned
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            n = -n;
            x = 1/x;
        }

        double result = 1;
        for(double i=n;i>0;i--){
            if (result == 0) {
                break;
            }
            result *= x;
        }

        return result;
    }
}
