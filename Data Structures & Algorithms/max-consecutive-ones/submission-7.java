class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            count = (num == 1) ? count + 1 : 0;
            if (res < count) {
                res = count;
            }
        }
        return res;
    }
}