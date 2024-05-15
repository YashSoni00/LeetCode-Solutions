package Medium;

public class StringToInteger {
    public static void main(String[] args) {
        String s = "-21474836482";
        int res = myAtoi(s);
        System.out.println(res);
    }

    public static int myAtoi(String s) {
        int len = s.length();
        int index = 0;
        int sign = 1;
        int num = 0;

        // Ignore WhiteSpaces
        while (s.charAt(index) == ' ')
            index++;

        // Check Sign
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        for (int i = index; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                long n = num;
                n *= 10;
                n += c - '0';
                if (n > Integer.MAX_VALUE && sign == 1) return Integer.MAX_VALUE;
                if (-n < Integer.MIN_VALUE && sign == -1) return Integer.MIN_VALUE;
                num = (int) n;
            } else {
                break;
            }
        }
        return sign * num;
    }
}
