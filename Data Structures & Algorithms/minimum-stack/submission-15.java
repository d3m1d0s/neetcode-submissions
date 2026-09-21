
class MinStack {

    private int[] array;
    private int capacity = 0;
    private int length = 0;
    private int[] minArray;
    private int capacityMin = 0;
    private int lengthMin = 0;

    public MinStack() {
        
    }

    public void printArray(int[] array) {
        for (int el : array) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
    
    public void push(int val) {

        if (length == 0) {
            array = new int[2];
            capacity = array.length;
        }
        if (lengthMin == 0) {
            minArray = new int[2];
            capacityMin = minArray.length;
        }
        if (length == capacity) {
            int[] old_array = array;
            array = new int[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                array[i] = old_array[i];
            }
            capacity = array.length;
        }
        if (lengthMin == capacityMin) {
            int[] old_minArray = minArray;
            minArray = new int[capacityMin * 2];
            for (int i = 0; i < capacityMin; i++) {
                minArray[i] = old_minArray[i];
            }
            capacityMin = minArray.length;
        }
        array[length] = val;
        length++;
        
        if (lengthMin == 0 || val <= minArray[lengthMin - 1]) {
            //printArray(minArray);
            minArray[lengthMin] = val;
            lengthMin++;
        }
    }
    
    public void pop() {
        if (array[length-1] == minArray[lengthMin - 1]) {
            lengthMin--;
        }
        length--;
    }
    
    public int top() {
        return array[length - 1];
    }
    
    public int getMin() {
        return minArray[lengthMin - 1];
    }
}
