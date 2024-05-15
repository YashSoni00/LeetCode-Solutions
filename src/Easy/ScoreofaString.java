package Easy;

public class ScoreofaString {
    public static void main(String[] args) {
        System.out.println(scoreOfString("(()(()))")); // 3
        System.out.println(scoreOfString("hello")); // 13
        System.out.println(scoreOfString("abracadabra")); // 78
        System.out.println(scoreOfString("abcdefghijklmnopqrstuvwxyz")); // 25
    }

    public static int scoreOfString(String s) {
        int score = 0;
        for (int i=0; i<s.length()-1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i+1));
        }
        return score;
    }
}
