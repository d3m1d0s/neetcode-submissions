class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        var returnValue = false
        var sortedNums = nums.sort()
        for (i in 0..nums.size-2) {
            if (nums[i] == nums[i+1]) returnValue = true
        }
        return returnValue
    }
}
