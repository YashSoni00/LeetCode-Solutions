package Easy;

// Link: https://leetcode.com/problems/reverse-prefix-of-word/
public class ReverseThePrefixOfAWord {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd')); // dcbaefd
        System.out.println(reversePrefix("xyxzxe", 'z')); // zyxxxe
        System.out.println(reversePrefix("abcd", 'z')); // abcd
    }

    public static String reversePrefix(String word, char ch) {
        // Find the index of the first occurrence of ch in word
        int index = word.indexOf(ch);

        StringBuilder sb = new StringBuilder();
        if (index != -1) {
            // Reverse the substring from the beginning of the word to the index
            sb.append(new StringBuilder(word.substring(0, index + 1)).reverse());
            // Append the rest of the word
            sb.append(word.substring(index + 1));
        } else {
            sb.append(word);
        }

        return sb.toString();
    }
}
