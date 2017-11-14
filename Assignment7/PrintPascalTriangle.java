package com.kevinshi721.Assignment7;

public class PrintPascalTriangle {

    public static void main(String[] args){
        printPascalTriangle(5);
    }

    public static void printPascalTriangle(int n){

        if(n==0){
            return;
        }
        int[][] triangle = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    triangle[i][j] = 1;
                }
                else{
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(triangle[i][j]);
            }
            System.out.println();
        }
    }
}
