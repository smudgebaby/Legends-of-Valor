package src;

import java.util.Random;

public class Board {

	//The class represents the board of the game
	
	private Cell[][] board;
	private int rowNum;
	private int colNum;
	
	public Board(int rowNum, int colNum) {
		this.rowNum = rowNum;
		this.colNum = colNum;
		board = new Cell[rowNum][colNum];
		iniBoard();
	}
	
	public int getRowNum() {
		return this.rowNum;
	}
	
	public int getColNum() {
		return this.colNum;
	}
	
	public void iniBoard() {
		Random random = new Random();
		int num;
		for(int i = 0; i<rowNum; i++) {
			for(int j = 0; j<colNum; j++) {
				num = random.nextInt(10);
				if(num == 0 || num == 1) {
					board[i][j] = new Cell(i,j,'&');
				}
				if(num == 2||num==3||num==4) {
					board[i][j] = new Cell(i,j,'M');
				}
				if(num>4) {
					board[i][j] = new Cell(i,j,' ');
				}
			}
		}
		board[rowNum-1][colNum-1] = new Cell(rowNum-1, colNum-1,' ');
	}
	
	public void setCell(int row, int col, char cell) {
		Cell temp = board[row][col];
		temp.setCellType(cell);
	}
	
	public char getCell(int row, int col) {
		Cell temp = board[row][col];
		return temp.getCellType();
	}
	
	public void printBoard() {
		System.out.print("+");
		for(int k = 0; k < colNum; k++) {
			System.out.print("--+");
		}
		for(int i = 0; i<rowNum; i++) {
			System.out.print("\n|");
			for(int j = 0; j<colNum; j++) {
				char t = board[i][j].getCellType();
				System.out.print(t +" |");
			}
			System.out.print("\n+");
			for(int p = 0; p<colNum;p++) {
				System.out.print("--+");
			}
		}
		System.out.println("\n");
		System.out.println("X: Location	M:Market	&:NonAccessable");
		System.out.println();
	}
	
	public int checkCellAccess(int row, int col, char cell) {
		if(row>=rowNum || col>=colNum || row<0 || col<0) {
			System.out.println("Invalid move!");
			return 1;
		}
		if(board[row][col].getCellType() == '&') {
			System.out.println("Inaccessible Cell!");
			return 2;
		}
		if(board[row][col].getCellType() == 'M') {
			return 3;
		}
		setCell(row, col, cell);
		return 0;
	}
	

}
