package Easy;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class FindTheSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        System.out.println(smallestLetter(letters, 'a'));
    }

    private static char smallestLetter(char[] letters, char target) {
            int beg = 0, end = letters.length-1, mid = 0;
            if (letters[end] <= target) return letters[beg];
            while (beg <= end){
                mid = beg + (end - beg)/2;
                if (letters[mid] > target) end = mid - 1;
                else beg = mid + 1;
            }
            return letters[beg];
    }
}
