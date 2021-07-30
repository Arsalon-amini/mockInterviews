import java.util.*;
import java.util.HashSet;
import java.util.Set;

class Program {
//Approach - Two pointers
    //O(n log n ) time
    //O(1) space
    public static int[] findValuesUsingPtrs(int[] array, int target) {
        Arrays.sort(array);
        int j = array.length - 1;
        int i = 0;

       while (i < j) {
            int currentSum = array[i] + array[j];
            if (currentSum < target) {
                i++;
            } else if (currentSum > target) {
                j--;
            } else {
                return new int[] {array[i], array[j]}
            }
        }
        return new int[0];
    }
    
    //Approach - hashMap
    //O(n) time 
    //O(n) space 
    public static int[] findValuesUsingHashMap(int[] array, int target) {
           Set<Integer> map = new HashSet<>();
        for(int i = 0; i < array.length; i++){
            int firstValue = array[i];
            int secondValue = target - firstValue;
            if (map.contains(secondValue)){
                return new int[] {firstValue, secondValue};
            } else if (!map.contains(secondValue)) {
                map.add(secondValue); 
            }
        }
        return new int[0]; 
    }
}