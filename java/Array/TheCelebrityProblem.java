package my.kkcuherenkov.java.Array;

/**
 * In a party of N people, only one person is known to everyone. 
 * Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. 
 * We can only ask questions like “does A know B? “. 
 * 
 * Find the stranger (celebrity) in minimum number of questions.*
 */

public class TheCelebrityProblem {

    public static void main(String args[]) {
        int matrix[][]= {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 1}
        };
        int index=0,c=0,ans=0;
        for(int i=1;i<matrix.length;i++) {
            if(matrix[index][i]==1) {
                index=i;
                ans++;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][index] == 1 && i != index)
                c++;
        }
        if(c==matrix.length-1) {
            System.out.println("The celebrity is " +(index+1) + " person  ");
            System.out.println("Max call to the function is "+ans);
        } else {
            System.out.println("No celebrity exist");
        }
    }

}
