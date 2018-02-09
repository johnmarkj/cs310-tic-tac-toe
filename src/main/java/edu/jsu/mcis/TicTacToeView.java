package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
		System.out.print("\n\n");
		System.out.print(" ");
		System.out.print(" ");
		for( int i = 0; i < model.getWidth(); i++ ){
			System.out.print(i);
		}
		
		System.out.print("\n");
		System.out.print("\n");
		
		for( int row = 0; row < model.getWidth(); row++ ){
			System.out.print( row + " " );
			for( int col = 0; col < model.getWidth(); col++ ){
				System.out.print( model.getMark( row, col ) );
			}
			System.out.print("\n");
		}
		
		System.out.print("\n\n");

    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
		if( model.isXTurn() ){
			System.out.println("Player 1 (X) Move:\n" + "Enter the row and column numbers, separated by a space.");
		}
		else{
			System.out.println("Player 2 (O) Move:\n" + "Enter the row and column numbers, separated by a space.");

		}
		
	}

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */
		System.out.println("Invalid Command!");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}