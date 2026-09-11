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

        int t = v;

        while (t != 0) {
            nums[t - 1] = nums[nums.length - t];
            nums[nums.length - t] = val;
            t--;
        }

        return k;
    }
}