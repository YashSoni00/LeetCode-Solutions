package Medium;

// Link: https://leetcode.com/problems/zigzag-conversion/
public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) {
            rows[i] = new StringBuilder();
        }
        boolean straight = true;
        int rowNumber = 0;
        for (int i=0; i<s.length(); i++) {
            if (i % numRows == numRows-1) straight = false;
            if (i % numRows == 0) straight = true;
            rows[rowNumber].append(s.charAt(i));
            if (straight) rowNumber++;
            else rowNumber--;
        }

        String result = "";
        for (int i=0; i<numRows; i++) {
            result += rows[i];
        }
        return result;
    }
}
