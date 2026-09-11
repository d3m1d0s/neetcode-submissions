class Solution {
    public int calPoints(String[] operations) {

     int sum = 0;
     int[] array = new int[operations.length];
     int k = 0;

     for (int i = 0; i < operations.length; i++) {
        int d = i - k;
        try {
            array[d] = Integer.parseInt(operations[i]);
            sum = sum + array[d];
        } catch (NumberFormatException e) {
            switch (operations[i]) {
                case "+":
                    array[d] = array[d-1] + array[d-2];
                                sum = sum + array[d];

                    break;
                case "D":
                    array[d] = 2 * array[d-1];
            sum = sum + array[d];

                    break;
                case "C":
                sum = sum - array[d-1];
                    k = k+2;
                    break;
                default:
                    
            }
        }

     }

     return sum;

    }


    public void printarray(int[] array) {
        for (int number : array) {
            System.out.print(number + ", ");
        }
        System.out.println();
    }
}

