package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY(" ");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */
		
		grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */
		
		for(int row = 0; row < width; row++){
			for(int col = 0; col < width; col++){
				grid[col][row] = Mark.EMPTY;
			}
		}
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /* INSERT YOUR CODE HERE */
		
		if ( isValidSquare(row,col) && !isSquareMarked(row,col) ) {
			if(xTurn){
				grid[row][col] = Mark.X;
				xTurn = false;
			}
			else{
				grid[row][col] = Mark.O;
				xTurn = true;
			}
			return true;
			
		}
			
		else{
			return false;
		}
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */
		
		if( row < width && col < width ){
			return true;
		}
		else{
			return false;
		}
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */
		
		if( row != Mark.EMPTY && col != Mark.EMPTY){
			return true;
		}
		else{
			return false;
		}
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */
		
		if( grid[row][col] == Mark.X){
			return Mark.X;
		}
		
		else if( grid[row][col] == Mark.O){
			return Mark.O;
		}
		
		else{
			return Mark.EMPTY;
		}
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
		if( isMarkWin(Mark.X) ){
			return Result.X;
		}
		else if( isMarkWin(Mark.O ) == true ){
			return Result.O;
		}
		else if( isTie() ){
			return Result.TIE;
		}
		else{
			return Result.NONE;
		}

    }
	
    private boolean isMarkWin(Mark mark) {
		
		private boolean xWon = true;
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
		
		for( int col = 0; col < width; col++ ){    // checks every column
			xWon = true;
			for( int row = 0; row < width; row++){
				if( grid[row][col] != mark ){
					xWon = false;
				}
				if(xWon == true){return true;}
			}
		}
		
		for( int row = 0; row < width; row++ ){   // checks every row
			xWon = true;
			for ( int col = 0; col < width; col++ ){
				if( grid[row][col] != mark ){
					xWon = false;
				}
				if(xWon == true){return true;}
			}
		}
		
		for( int row = 0; row < width; row++ ){   // checks diagonals top-right to bottom-left
			int col = width - row - 1;
			if( grid [row][col] != mark ){
				xWon = false;
			}
			if(xWon == true){return true;}
		}
		
		for( int x = 0; x < width; x++){         // checks diagonals bottom-right to top-left
			int row = width - 1 - x;
			int col = width - 1 - x;
			if( grid[row][col] != mark){
				xWon = false;
			}
			if(xWon == true){return true;}
		}
		return false;
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
		
		for( row = 0; row < width; row++ ){
			for(col = 0; col < width; col++){     // checks every square
				if( grid[row][col] == Mark.EMPTY ){
					return false;
				}
			}
		}
		return true;
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}