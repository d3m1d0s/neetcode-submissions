class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter = 0;
            }
            if (result < counter) {
                result = counter;
            }
        }

        return result;
    }
}