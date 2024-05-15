package Easy;

// Source: https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int a1=0, a2=0;
        int[] arr = new int[nums1.length];
        for (int i=0; i<nums1.length; i++){
            if (a2 >= n) {// All of the elements of nums2 are added
                arr[i] = nums1[a1];
                a1++;
            } else if (a1 >= m) {// All of the elements of nums1 are added
                arr[i] = nums2[a2];
                a2++;
            } else if (nums1[a1] > nums2[a2]){
                arr[i] = nums2[a2];
                a2++;
            } else {
                arr[i] = nums1[a1];
                a1++;
            }
        }

        for (int i=0; i<nums1.length; i++)
            nums1[i] = arr[i];
    }
}
