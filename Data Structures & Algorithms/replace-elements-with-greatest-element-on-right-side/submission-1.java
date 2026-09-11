class Solution {
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        int last = 0;
        for (int i = arr.length - 2; i > -1; i--) {
            if (last > max) {
                max = last;
            }
            last = arr[i];
            arr[i] = max;
        }

        arr[arr.length - 1] = -1;

        return arr;
    }
}