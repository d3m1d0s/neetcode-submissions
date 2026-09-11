class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] newarr = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            newarr[i] = nums[i];
            newarr[i+nums.length] = nums[i];
        }

        return newarr;
    }
}