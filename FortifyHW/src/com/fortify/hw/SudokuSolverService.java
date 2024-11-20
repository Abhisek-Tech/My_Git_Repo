/**
 * 
 */
package com.fortify.hw;

/**
 * @author abhisekparida
 *
 */
public class SudokuSolverService {
	
	private static boolean isSafeToPlace(int val, int[][] board, int row, int col) {
		
		for(int i = 0; i < board.length; i++) {
			//row check
			if(board[row][i] == val) {
				return false;
			}
			
			//column check
			if(board[i][col] == val) {
				return false;
			}
				
			
			//3*3 grid check
			if(board[3*(row/3) + i/3][3*(col/3)+ i%3] == val) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean solveSudoku(int[][] board) {
		
		int n = board.length;
		int m = board[0].length;
		
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < m; col++) {
				if(board[row][col] == 0) {
					for(int val = 1 ; val <= 9; val++) {
						if(isSafeToPlace(val, board, row, col)) {
							board[row][col] = val;
							//do recursion assuming this value fit for this place.
							if(solveSudoku(board)) {
								return true;
							}else {
							//do backtrack if solution not valid
								board[row][col] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
		
    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create test data.
		//Sudoku1 - Valid Sudoku(Input provided by example grid in input)
		int[][] sudoku1 = new int[][] {{0,1,3,8,0,0,4,0,5},{0,2,4,6,0,5,0,0,0},{0,8,7,0,0,0,9,3,0},
			{4,9,0,3,0,6,0,0,0},{0,0,1,0,0,0,5,0,0},{0,0,0,7,0,1,0,9,3},{0,6,9,0,0,0,7,4,0},{0,0,0,2,0,7,6,8,0},{1,0,2,0,0,8,3,5,0}};
		
		if(solveSudoku(sudoku1)) {
			System.out.println("The Sudoku1 is solved - WOW!!");
		}else {
			System.out.println("The Sudoku1 can't be solved !");
		}
		
		
		//Sudoku2 - Valid Sudoku(Input provided by example grid in input)
		int[][] sudoku2 = new int[][] {{0,0,2,0,0,0,0,4,1},{0,0,0,0,8,2,0,7,0},{0,0,0,0,4,0,0,0,9},
			{2,0,0,0,7,9,3,0,0},{0,1,0,0,0,0,0,8,0},{0,0,6,8,1,0,0,0,4},{1,0,0,0,9,0,0,0,0},{0,6,0,4,3,0,0,0,0},{8,5,0,0,0,0,4,0,0}};
		
		if(solveSudoku(sudoku2)) {
			System.out.println("The Sudoku2 is solved - WOW!!");
		}else {
			System.out.println("The Sudoku2 can't be solved !");
		}
		
		////Sudoku3 - InValid Sudoku by changing some random value.
		int[][] sudoku3 = new int[][] {{0,1,3,8,0,0,4,0,5},{0,2,4,6,0,5,0,0,0},{0,8,7,0,0,0,9,3,0},
			{4,9,0,3,0,6,0,0,0},{0,0,1,0,0,0,5,0,0},{0,8,8,8,8,8,8,8,8},{0,6,9,0,0,0,7,4,0},{0,0,0,2,0,7,6,8,0},{1,0,2,0,0,8,3,5,0}};
		
			if(solveSudoku(sudoku3)) {
				System.out.println("The Sudoku3 is solved - WOW!!");
			}else {
				System.out.println("The Sudoku3 can't be solved !");
			}
			
		//the time complexity -  O(9^m) (where m is number of free space)
		//the space complexity - O(1).

	}

}
