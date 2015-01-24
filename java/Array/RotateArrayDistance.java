package my.kkcuherenkov.java.Array;

/*
Find the rotation distance of a rotated sorted array. 

For example: 
input:
4, 5, 6, 1, 2, 3
output:
3
input:
1, 2, 3, 4, 5, 6
output:
0
input:
2, 3, 4, 5, 6, 1
output:
1
*/

/*
solution: Find the maximal difference of consecutive two elements, and record the position.
Pay attention to the situation that new difference is the same as current maximal difference. 
O(n) time, O(1) space
*/

import java.util.Arrays;

public class RotateArrayDistance {
    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 1, 2, 3};
        int arr1[] = {1, 2, 3, 4, 5, 6};
        int arr2[] = {2, 3, 4, 5, 6, 1};
        System.out.println("for array " + Arrays.toString(arr) + " min rotation distance is " + rotationDistance(arr));
        System.out.println("for array " + Arrays.toString(arr1) + " min rotation distance is " + rotationDistance(arr1));
        System.out.println("for array " + Arrays.toString(arr2) + " min rotation distance is " + rotationDistance(arr2));
    }

    private static int rotateMinStep(int k, int len) {
        int p = k + 1;
        if (p < len - p) 
            return p;
        return len - p;
    }

    private static int rotationDistance(int arr[]) {
        int length = arr.length;
        if (length == 1) return 0;

        int maxDiff = Math.abs(arr[0] - arr[1]);
        int maxPos = 0;

        for (int i = 1; i < length; ++i) {

            int diff = Math.abs(arr[i] - arr[(i + 1) % length]);

            if (diff > maxDiff) {
                maxDiff = diff;
                maxPos = i;
            } else if (diff == maxDiff) {
                // equals
                int len1 = rotateMinStep(maxPos, length);
                int len2 = rotateMinStep(i, length);
                if (len2 < len1) {
                    maxDiff = diff;
                    maxPos = i;
                }
            }
        }

        return rotateMinStep(maxPos, length);
    }
}
