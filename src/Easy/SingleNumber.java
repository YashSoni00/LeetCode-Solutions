package Easy;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = n ^ num;
        }
        return n;
    }
}
