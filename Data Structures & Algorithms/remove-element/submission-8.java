class Solution {
    public int removeElement(int[] nums, int val) {
      int k = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
          if (k != i) {
            nums[k] = nums[i];
            nums[i] = -1;
          }
          k++;
        } else {
          nums[i] = -1;
        }
      }

      return k;
    }
}