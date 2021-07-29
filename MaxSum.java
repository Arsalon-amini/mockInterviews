//pseudocode

public class Program {
    //O(n) time and O(n) space 
    public static int maxSumNoAdjacent(int[] array){
    int [] maxSums = array.clone();

    maxSums[1] = Math.max(maxSums[0], array[1]);

    for(int i = 0; i < array.length; i++){
        maxSums[i] = Math.max(maxSums[i - 1], array[i] + maxSums[i - 2]); 
    }
    return maxSums[array.length - 1]; //returns the final result

    //O(n) time and O(1) space - only storing first and second variables not entire intermediary array 
    public static int maxSumNoAdjacentsV2(int[] array) {
        int first = array[0];
        int second = Math.max(first, array[1]);
        for (int i = 2; i < array.length; i++) {
            var current = Math.max(first, second + array[i]);
            first = second;
            second = current;
        }
        return second; 
}
}



