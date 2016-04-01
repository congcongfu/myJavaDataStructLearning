package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import test.stackTest;

public class Maze {

	private static final int TRIED = 2;
	private static final int PATH = 3;
	
	private int numberRows, numberColumns;
	private int[] [] grid;
	
	/*
	 * Constructor for the Maze class. Load a maze from the given file;
	 * Throws a FileNotFoundException if the given file is not found
	 * @param fileName the name of the file to load
	 * @throws FileNotFoundException if the given file is not found
	 * */
	public Maze(String fileName) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(fileName));
		numberRows = scanner.nextInt();
		numberColumns = scanner.nextInt();
		grid = new int[numberRows][numberColumns];
		for(int i = 0; i < numberRows; i++){
			for(int j = 0; j < numberColumns; j++){
				grid[i][j] = scanner.nextInt();
			}
		}
	}
	
	/*
	 * Marks the specified position in the maze as TRIED
	 * @param row the index of the row to try
	 * @param col the index of the column to try
	 * */
	public void tryPosition(int row, int col){
		grid[row][col] = TRIED;
	}
	
	/*
	 * Return the number of rows in this maze
	 * @return the number of row in this maze
	 * */
	public int getRows(){
		return grid.length;
	}
	
	/*
	 * Return the number of columns in this maze
	 * return the number of columns in this maze
	 * */
	public int getColumns(){
		return grid[0].length;
	}
	
	/*
	 * Marks a given position in the maze as part of the PATH
	 * @param row the index of the row to mark as part of the PATH
	 * @param col the index of the column to mark as part of the PATH
	 * */
	public void markPath(int row, int col){
		grid[row][col] = PATH;
	}
	
	/*
	 * Determines if a specific location is valid. A valid location
	 * is one that is on the grid, is not blocked, and has not been TRIED
	 * @param row the row to be checked
	 * @param column the column to be checked
	 * @return true if the location is valid
	 * */
	public boolean validPositon(int row, int column){
		boolean result = false;
		
		//check if the cell is in the bounds of the matrix
		if(row >= 0 && row < grid.length &&
				column >= 0 && column < grid[row].length)
			//check if cell is not blocked and not previously tried
			if(grid[row][column] ==1)
				result = true;
		return result;
	}
	
	/*
	 * Returns the maze as a string
	 * @return a string representation of the maze
	 * */
	public String toString(){
		String result = "[";
		for (int row = 0; row < grid.length; row++){
			for(int column = 0; column < grid[row].length; column++){
				result += grid[row][column] ;
				if(column < (grid[row].length -1)){
					result += ",";
				}
			}
				
			
		}
		result += "]";
		return result;
	}
}


























