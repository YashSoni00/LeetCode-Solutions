package Medium;

public class Test {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits(964176192));
    }

    public static int reverseBits(int n) {
        int result = 0;
        char[] s = Integer.toBinaryString(n).toCharArray();
        int zeros = 32 - s.length;
        for (int i = s.length - 1; i >= 0; i--) {
            result <<= 1;
            if (s[i] == '1') {
                result |= 1;
            }
        }
        result <<= zeros;

        return result;
    }
}
