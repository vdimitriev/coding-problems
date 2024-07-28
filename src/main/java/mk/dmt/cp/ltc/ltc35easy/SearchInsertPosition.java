package mk.dmt.cp.ltc.ltc35easy;

public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] nums1 = new int[]{1,3};
        int target1 = 3;
        int res1 = sip.searchInsert(nums1, target1);
        System.out.println("res1 = " + res1);

//        int[] nums1 = new int[]{1,3,5,6};
//        int target1 = 5;
//        int res1 = sip.searchInsert(nums1, target1);
//        System.out.println("res1 = " + res1);
//
//        int[] nums2 = new int[]{1,3,5,6};
//        int target2 = 2;
//        int res2 = sip.searchInsert(nums2, target2);
//        System.out.println("res2 = " + res2);
//
//        int[] nums3 = new int[]{1,3,5,7};
//        int target3 = 6;
//        int res3 = sip.searchInsert(nums3, target3);
//        System.out.println("res3 = " + res3);
//
//        int[] nums4 = new int[]{1,3,5,6};
//        int target4 = 7;
//        int res4 = sip.searchInsert(nums4, target4);
//        System.out.println("res4 = " + res4);
    }
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) {
            if(target == nums[0] || target < nums[0]) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return search(nums, 0, nums.length - 1, target);
        }

    }

    private int search(int[] nums, int start, int end, int target) {
        for(int i = start; i<= end; i++) {
            System.out.println("i = " + i + ", num = " + nums[i]);
        }
        if(end == start) {
            System.out.println("3. start = " + start + ", end = " + end + ", target = " + target);
            if(target < nums[end] || target == nums[end]) {
                return end;
            } else {
                return end + 1;
            }
        }
        int middle = (end + start) / 2;
        if(nums[middle] == target) {
            System.out.println("4. middle = " + middle + ", start = " + start + ", end = " + end + ", target = " + target);
            return middle;
        } else if(target < nums[middle]) {
            System.out.println("1. middle = " + middle + ", start = " + start + ", end = " + end + ", target = " + target);
            return search(nums, start, middle, target);
        } else {
            System.out.println("2. middle = " + middle + ", start = " + start + ", end = " + end + ", target = " + target);
            return search(nums, middle + 1, end, target);
        }
    }
}
