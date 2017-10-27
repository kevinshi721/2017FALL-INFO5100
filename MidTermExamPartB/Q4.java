package com.kevinshi721;

import java.util.Arrays;

public class Q4 {
    public static void main(String[] args) {

        Q4 q4 = new Q4();
        System.out.println(q4.countNumberOfPossibleWays(5,3,7));
    }

    public int countNumberOfPossibleWays(int m, int n, int x){

        int table[][] = new int[n+1][x+1];

        table[0][0] = 1;

        for(int i=1; i <= n; i++){
            for(int j =1; j <= i * m && j <= x; j++){
                if(j == i){
                    table[i][j] = 1;
                    continue;
                }
                if(j < i){
                    continue;
                }
                for(int k =1; k <= m; k++){
                    if(k <= j){
                        table[i][j] += table[i-1][j-k];
                    }
                }
            }
        }
        // check table
        for (int[] arr : table) {
            System.out.println(Arrays.toString(arr));
        }

        return table[n][x];
    }
}


