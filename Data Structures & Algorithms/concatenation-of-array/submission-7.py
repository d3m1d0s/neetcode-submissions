class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:

        # return num * 2
        # return num + num

        #arr = []
        #arr.extend(nums)
        #arr.extend(nums)

        #for n in nums:
        #    arr.append(n)
        #for n in nums:
        #    arr.append(n)

        arr = [0] * len(nums) * 2
        n = len(nums)

        #arr[:n] = nums
        #arr[n:] = nums

        for i in range(n):
            arr[i] = nums[i]
            arr[n + i] = nums[i]

        return arr
        