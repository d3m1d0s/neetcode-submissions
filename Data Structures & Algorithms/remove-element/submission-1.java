class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int v = 0;
        for (int i = 0; i < nums.length; i++) {
          if (nums[i] != val) {
            k++;
            continue;
          }
          else {
            if (i > 0) {
                          nums[i] = nums[v];
                         nums[v] = val;

            }
            v++;
          }
        }

        while (v != 0) {
            nums[v - 1] = nums[nums.length - v];
            nums[nums.length - v] = val;
            v--;
        }

        return k;
    }
}