class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        k = 0
        for n in nums:
            if n != val:
                if nums.index(n) != k:
                    nums[k] = n
                    n = -1
                k+=1
            else:
                n = -1
        return k

        
        