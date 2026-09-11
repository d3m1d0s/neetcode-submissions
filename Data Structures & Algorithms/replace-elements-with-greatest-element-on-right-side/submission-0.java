class Solution {

 public int maxim(int i, int[] arr) {

    if (i+1 >= arr.length) {
        return -1;
    }

    int max = arr[i+1];

    for (int j = i+2; j < arr.length; j++) {
       if (arr[j] > max) {
        max = arr[j];
       }
    }

     return max;

    
 }

    public int[] replaceElements(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = maxim(i, arr);
        }

        return arr;
    }
}