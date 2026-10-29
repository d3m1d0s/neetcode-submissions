class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var sol = IntArray(2)
        for (i in 0..nums.size-2) {
            for (j in 1..nums.size-1) {
                if (i == j) continue
                if (nums[i] + nums[j] == target) {
                    sol = intArrayOf(i, j)
                    return sol
                }
            }
        }
        return sol
    }
}
 