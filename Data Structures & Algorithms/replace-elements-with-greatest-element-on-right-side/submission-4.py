class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        mx = last = arr[-1]
        arr[-1] = -1
        for i in reversed(range(len(arr) - 1)):
            mx = last if last > mx else mx
            last = arr[i]
            arr[i] = mx
            
        return arr

        