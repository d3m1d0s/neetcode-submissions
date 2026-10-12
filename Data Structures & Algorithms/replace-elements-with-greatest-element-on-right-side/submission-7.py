class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        mx = last = arr[-1]
        arr[-1] = -1
        for i in range(len(arr) - 2, -1, -1):
            mx = max(mx,last)
            last = arr[i]
            arr[i] = mx
            
        return arr

        