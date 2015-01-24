package my.kkcuherenkov.java.Array;

/*
Given an array of numbers, nums, return an array of numbers products, where
products[i] is the product of all nums[j], j != i.

For example:
Input : [1, 2, 3, 4, 5]
Output: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)]
      = [120, 60, 40, 30, 24]
You must do this in O(n) without using division.
*/

/*
solution: scan two times.
O(n) time, O(1) space
*/

import java.util.Arrays;

public class BuildArrayOfProducts {
    public static void main(String args[]) {
        int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(BuildArray(array)));
    }

    /**
     *Input: array input[]
     *Output: array output[] is the output array
     **/
    private static int[] BuildArray(int input[]) {
        int length = input.length;
        int[] output = new int[length];
        output[length-1] = 1;
        for (int i = length-2; i >= 0; i--) {
            output[i] = output[i+1] * input[i+1];
        }
        int allRestInput = 1;
        for (int i = 1; i < length; i++) {
            allRestInput *= input[i-1];
            output[i] = output[i] * allRestInput;
        }
        return output;
    }
}
