class Solution {
    public int removeElement(int[] nums, int val) {
      if (nums.length > 0) {
        nums[nums.length - 1] = (nums[nums.length - 1] == val) ? -1 : nums[nums.length - 1];
        int i_of_last_other = nums.length - 1;
        int k = (nums[nums.length - 1] == -1) ? nums.length - 1 : nums.length;
        for (int i = nums.length - 2; i > -1; i--) {
          if (nums[i] != val) {
            if (nums[i + 1] == -1) {
              i_of_last_other = i;
            }
          } else {
            nums[i] = nums[i_of_last_other];
            nums[i_of_last_other] = -1;
            i_of_last_other--;
            k--;
          }
        }
        return k;
      } else {
        return 0;
      }
    }
}