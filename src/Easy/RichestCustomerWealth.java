package Easy;

// https://leetcode.com/problems/richest-customer-wealth/
public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {{1,2,4},{5,2,1}};
        System.out.println(maxWealth(accounts));
    }

    //    My solution:
    private static int maxWealth(int[][] accounts) {
        int result = 0;
        for (int[] person: accounts){
            int total = 0;
            for (int bal: person){
                total += bal;
            }
            if (result < total) result = total;
        }
        return result;
    }
}