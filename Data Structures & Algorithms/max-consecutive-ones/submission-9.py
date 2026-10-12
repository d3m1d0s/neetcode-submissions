class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        cnt = mx = 0
        for n in nums:
            if n == 1:
                cnt+=1
            elif n == 0:
                cnt = 0
            mx = cnt if cnt > mx else mx
        return mx


        