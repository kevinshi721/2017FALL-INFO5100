import java.util.Arrays;

public class Question6 {

	public static void main(String[] args) {
		int [] nums1 = {2,5,11,9};
		int [] nums2 = {3,7,8,10};
		Question6 test = new Question6();
		System.out.println(test.findMedianSortedArrays(nums1, nums2));
		
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int [] mergedArray = new int [m+n];
        System.arraycopy(nums1, 0, mergedArray, 0, m);
        System.arraycopy(nums2, 0, mergedArray, m, n);
        
        Arrays.sort(mergedArray);
        
        System.out.println(Arrays.toString(mergedArray));
        
        if ((m+n) % 2 != 0) {
        		return mergedArray[(m + n) / 2];
        } else {
        		return ((mergedArray[(m + n) / 2 - 1] + mergedArray[(m + n) / 2]) / 2.0);
        }
        
    }
}
