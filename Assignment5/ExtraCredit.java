
/*
 1. Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.  (Score 2)
	For example, Given the following matrix: 
	{{1,2,3},
	 {4,5,6},
	 {7,8,9}}
	 You should return {1,2,3,6,9,8,7,4,5}.
*/	    

import java.util.LinkedList;
import java.util.List;

public class ExtraCredit {
	public static void main (String[] args) {
		int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
		
		ExtraCredit ec = new ExtraCredit();
		System.out.print(ec.spiralOrder(matrix));
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
	    
		List<Integer> so = new LinkedList<>();  
		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		int columnStart = 0;
		int columnEnd = matrix[0].length - 1;  
		
		while(rowStart <= rowEnd && columnStart <= columnEnd) {  
			for(int i = columnStart; i <= columnEnd; i++) 
				so.add(matrix[rowStart][i]);
	        
			for(int i = rowStart + 1; i <= rowEnd -1; i++) 
				so.add(matrix[i][columnEnd]);
			
			if(rowStart != rowEnd) {
				for(int i = columnEnd; i >= columnStart; i--) 
					so.add(matrix[rowEnd][i]);  
			}

			if(columnStart != columnEnd) {  
				for(int i = rowEnd - 1; i >= rowStart + 1; i--)
					so.add(matrix[i][columnStart]);  
			}
		rowStart++;
		columnEnd--;
		rowEnd--;
		columnStart++;
		}
	return so;
	}
}