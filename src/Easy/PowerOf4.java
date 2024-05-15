package Easy;

// https://leetcode.com/problems/power-of-four/?envType=daily-question&envId=2023-10-23
public class PowerOf4 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }
    public static boolean isPowerOfFour(int n) {
//        if (n==0) return false;
//        while (n%4==0){
//            n = n/4;
//        }
//        return n==1;
//        Or we can do this like

        if (n==0) return false;
        return (Math.log10(n)/Math.log10(4)) == (int)(Math.log10(n)/Math.log10(4));
    }
}
