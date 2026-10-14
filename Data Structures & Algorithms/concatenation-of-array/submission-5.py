class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        # return num + num
        #arr = []
        #arr.extend(n for n in nums)
        #arr.extend(n for n in nums)
        #for n in nums:
        #    arr.append(n)
        #for n in nums:
        #    arr.append(n)

        arr = [0] * len(nums) * 2

        for i in range(len(nums)):
            arr[i] = nums[i]
            arr[len(nums) + i] = nums[i]

        return arr
        