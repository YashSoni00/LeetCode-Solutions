package Easy;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{4,1,2,3,1,5}, 3)); // true
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for (int i=0; i<len; i++){
            for (int j=1; j<=k; j++){
                if (i+j < len && nums[i] == nums[i+j]){
                    return true;
                }
            }
        }
        return false;
    }
}
