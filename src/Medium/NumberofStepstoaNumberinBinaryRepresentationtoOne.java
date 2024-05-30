package Medium;

public class NumberofStepstoaNumberinBinaryRepresentationtoOne {
    public static void main(String[] args) {
        System.out.println(numSteps("1101")); // 6
        System.out.println(numSteps("10")); // 1
        System.out.println(numSteps("1")); // 0
    }

    public static int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int steps = 0;
        while(sb.length() != 1) {
            if (sb.charAt(sb.length()-1) == '0') {
                // Even
                sb.deleteCharAt(sb.length()-1);
            } else {
                // Odd - 1111 -> 10000
                int i = sb.length()-1;
                while(i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }
                if (i == -1) {
                    sb.insert(0, '1');
                } else {
                    sb.setCharAt(i, '1');
                }
            }
            steps++;
        }
        return steps;
    }
}
