import java.util.ArrayList;
import java.util.Scanner;
public class PegGame{
	ArrayList<Character> row1 = new ArrayList<>();
	ArrayList<Character> row2 = new ArrayList<>();
	ArrayList<Character> row3 = new ArrayList<>();

	public void createBoard() {
//THIS METHOD CREATES THE BOARD
		char x = '@';
		char y = '-';
		row1.add(x);
		row1.add(x);
		row1.add(y);
		
		for (int i = 1; i <= 3; i++){row2.add(x);}
		for (int i = 1; i <= 3; i++){row3.add(x);}
		}
	
	public void printBoard() {
//WHEN CALLED THIS METHOD PRINTS THE BOARD
	for (int i = 0; i <= 2; i++) {System.out.print(row1.get(i));}
		System.out.println("");
		
	for (int i = 0; i <= 2; i++) {System.out.print(row2.get(i));}
		System.out.println("");
	
	for (int i = 0; i <= 2; i++) {System.out.print(row3.get(i));}
		System.out.println("");
	}
	
	
	public void firstMove() {
//THIS METHOD WILL RUN AT THE BEGGINING OF A GAME TO HELP EXPLAIN THE RULES
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int column = input.nextInt();
		
		System.out.println("Now enter which way you want to move. "
				+ "Entering 1 moves up, entering 2 moved rights. 3 is down, and 4 is left.");
		int move  = input.nextInt();
		
		if(row  == 1 && column == 1 && move == 2) {
			System.out.println("Congrats this is a valid move! From now on you will be prompted to select a peg and then a move" 
					+ "Here is the board now.");
			row1.set(0, '-');
			row1.set(1, '-');
			row1.set(2, '@');
			}
		else if(row == 3 && column == 3 && move == 1) {
			System.out.println("Congrats this is a valid move! From now on you will be prompted to select a peg and then a move"
					+ "Here is the board now.");
			row1.set(2, '@');
			row2.set(2, '-');
			row3.set(2, '-');
		}
		else {
			System.out.println("Invalid move. Try again");
			System.out.println("Select a peg");
			firstMove();}
	}
	
	public void MoveStart() {
		Scanner select = new Scanner(System.in);
//THIS METHOD GAINS USER INPUT AND DECIDES IF THE SELECTED MOVE AND PEG COMBINATION IS WITHIN THE BOUNDRIES
		
		System.out.print("Select a peg:");
		int pegRow = select.nextInt();
		int pegCol = select.nextInt() - 1;
		
		System.out.print("Make a move: ");
		int pegMove = select.nextInt();
	// is your selection within the boundaries
		
		if(pegRow==1 && pegMove==1){System.out.println("Invalid peg/move selection. Try again"); MoveStart(); }
		else if(pegCol == 3 && pegMove == 2){System.out.println("Invalid peg/move selection. Try again"); MoveStart();}
		else if(pegCol == 1 && pegMove == 4){System.out.println("Invalid peg/move selection. Try again"); MoveStart();}
		else if(pegRow == 3 && pegMove == 3){System.out.println("Invalid peg/move selection. Try again"); MoveStart();}
		else if(pegRow == 2 && pegMove == 1){System.out.println("Invalid peg/move selection. Try again"); MoveStart(); }
		else if(pegRow == 1 && pegMove == 1){System.out.println("Invalid peg/move selection. Try again"); MoveStart(); }
		else if(pegRow == 2 && pegMove == 3){System.out.println("Invalid peg/move selection. Try again"); MoveStart(); }
		else if(pegCol == 2 && pegMove == 1){System.out.println("Invalid peg/move selection. Try again"); MoveStart(); }
		else if(pegCol == 2 && pegMove == 3){System.out.println("Invalid peg/move selection. Try again"); MoveStart(); }
		
		else if(pegRow > 3){System.out.println("Invalid peg/move selection. Try again"); MoveStart();}
		else if(pegCol > 3){System.out.println("Invalid peg/move selection. Try again"); MoveStart();}
		else if(pegMove > 4){System.out.println("Invalid peg/move selection. Try again"); MoveStart();}
		
		else {MoveCheck(pegRow, pegCol, pegMove);}
	
	}
	
	

	
	
	public void MoveCheck( int pegRow, int pegCol, int pegMove) {
//THIS METHOD MAKES SURE THAT YOU ARE JUMPING A PEG, YOU HAVE TO JUMP A PEG EVERY MOVE
		char peg;
		char pegJumped;
		char pegLand;
		
		if(pegRow == 1) {peg = row1.get(pegCol);}
		else if(pegRow == 2) {peg = row2.get(pegCol);}
		else if(pegRow == 3) {peg = row3.get(pegCol);}
		else {peg = 'x';}
		
		if (pegMove == 2) {
			if(pegRow == 1) {pegJumped = row1.get(pegCol + 1);}
			else if(pegRow == 2) {pegJumped = row2.get(pegCol + 1);}
			else if(pegRow == 3) {pegJumped = row3.get(pegCol + 1);}
			else {pegJumped = 'X';}
			}
		else if (pegMove == 4) {
			if(pegRow == 1) {pegJumped = row1.get(pegCol - 1);}
			else if(pegRow == 2) {pegJumped = row2.get(pegCol - 1);}
			else if(pegRow == 3) {pegJumped = row3.get(pegCol - 1);}
			else {pegJumped = 'X';}
		}
		else if (pegMove == 1) {
			if(pegRow == 2) {pegJumped = row1.get(pegCol);}
			else if(pegRow == 3) {pegJumped = row2.get(pegCol);}
			else {pegJumped = 'X';}
		}
		else if (pegMove == 3 ) {
			if(pegRow == 1) {pegJumped = row2.get(pegCol);}
			else if(pegRow == 2) {pegJumped = row3.get(pegCol);}
			else {pegJumped = 'X';}
		}
		else {pegJumped = 'X';}
		
		
//FOLLOWING CHUNK OF CODE CHECKS TO SEE IF YOU ARE LANDING ON A PEG OR AN EMPTY SPACE
		if (pegMove == 2) {
			if(pegRow == 1) {pegLand = row1.get(pegCol + 2);}
			else if(pegRow == 2) {pegLand = row2.get(pegCol + 2);}
			else if(pegRow == 3) {pegLand = row3.get(pegCol + 2);}
			else {pegLand = 'X';}
		}
		else if (pegMove == 4) {
			if(pegRow == 1) {pegLand = row1.get(pegCol - 2);}
			else if(pegRow == 2) {pegLand = row2.get(pegCol - 2);}
			else if(pegRow == 3) {pegLand = row3.get(pegCol - 2);}
			else {pegLand = 'X';}
		}
		else if (pegMove == 1) {
			if(pegRow == 3) {pegLand = row1.get(pegCol);}
			else {pegLand = 'X';}
		}
		else if (pegMove == 3 ) {
			if(pegRow == 1) {pegLand = row3.get(pegCol);}
			else {pegLand = 'X';}
		}
		else {pegLand = 'X';}
		
		
		
//if-else below decides if you need to retry your move or if its good to perform the move
		if (peg =='@' && pegJumped == '@' && pegLand == '-') {
			Move(pegRow, pegCol, pegMove);
			}
		else {System.out.println("Invalid move. Please try again."); MoveStart();}
		
	
		}

	public void Move(int pegRow, int pegCol, int pegMove) {
//if this method runs, then we should now now that the move is valid and should compute the results of the move

	
		char empty = '-';
		
//following if statement makes the old location of the peg that has performed a jump into a '-'
		if(pegRow == 1) {row1.set(pegCol, empty);}
		else if(pegRow == 2) {row2.set(pegCol, empty);}
		else if(pegRow == 3) {row3.set(pegCol, empty);}
	
		
//following if then statement changed jumped peg to '-'
		if (pegMove == 2) {
			if(pegRow == 1) {row1.set(pegCol + 2, '@'); row1.set(pegCol + 1, '-');}
			else if(pegRow == 2) {row2.set(pegCol + 2, '@'); row2.set(pegCol + 1, '-');}
			else if(pegRow == 3) {row3.set(pegCol + 2, '@'); row3.set(pegCol + 1, '-');}
			}
		
		else if (pegMove == 4) {
			if(pegRow == 1) {row1.set(pegCol - 2, '@');row1.set(pegCol - 1, empty);}
			else if(pegRow == 2) {row2.set(pegCol - 2, '@'); row2.set(pegCol - 1, empty);}
			else if(pegRow == 3) {row3.set(pegCol - 2, '@'); row3.set(pegCol - 1, empty);}
		}
		
		else if (pegMove == 1) {
			if(pegRow == 3) {row1.set(pegCol, '@'); row2.set(pegCol, empty);}
		}
		
		else if (pegMove == 3 ) {
			if(pegRow == 1) {row3.set(pegCol, '@'); row2.set(pegCol, empty);}
		}
		
		
		}
	
	public boolean gameWin() {
//AS NAME SUGGESTS, THIS METHOD CHECKS TO SEE IF YOU HAVE WON
		
		ArrayList<Integer> winCheck = new ArrayList<Integer>();
		for(int i = 0; i<=2; i++) {
		 if(row1.get(i) == '@') {winCheck.add(i);}
		 else if(row2.get(i) == '@') {winCheck.add(i);}
		 else if(row3.get(i) == '@') {winCheck.add(i);}
		}
		
		if(winCheck.size() == 1) {System.out.println("NICE GAME! YOU WIN!"); return true;}
		else {return false;}	
	}
	
	public boolean moveOptions() {
		char Jumped;
		
		ArrayList<Integer> lostCheck = new ArrayList<Integer>();
//has to be a better way to do this than checking for every single scenario
		
/*this method checks if there are any possible jumps for each position
 *  if a move is possible then it will add an integer to the list
 *  in the end of the method if there are no possible moves it will return true
 
 */
//1 1
		if(row1.get(0) == '@' && row1.get(1) == '@' && row2.get(0) == '-') 
			 	{lostCheck.add(1);}
		else if (row1.get(0) == '@' && row2.get(0) == '@' && row3.get(0) == '-')
			 	{lostCheck.add(1);}
		
//2	1		 
		if(row2.get(0) == '@' && row2.get(1) == '@' && row2.get(2) == '-')
			 	{lostCheck.add(1);}
		

//3	1 
		if(row3.get(0) == '@' && row2.get(0) == '@' && row3.get(1) == '-') 
			 	{lostCheck.add(1);}
		else if(row3.get(0) == '@' && row3.get(1) == '@' && row3.get(2) == '-')
			 	{lostCheck.add(1);}
		
//1 2	
		if(row1.get(1) == '@' && row2.get(1) == '@' && row3.get(1) == '-')
			 	{lostCheck.add(1);}

//2 2 WE DONT NEED TO CHECK THIS ONE BECAUSE YOU CAN NEVER BEGIN A MOVE HERE
		
//3 2
		if(row3.get(1) == '@' && row2.get(1) == '@' && row1.get(1) == '-')
			 	{lostCheck.add(1);}
			 
//1 3	 
		if(row1.get(2) == '@' && row1.get(1) == '@' && row1.get(0) == '-') 
			 	{lostCheck.add(1);}
		else if (row1.get(2) == '@' && row2.get(2) == '@' && row3.get(2) == '-')
				{lostCheck.add(1);}
		
//2 3		 
		if(row2.get(2) == '@' && row2.get(1) == '@' && row2.get(0) == '-')
			 	{lostCheck.add(1);}
			 
//3 3			 
		if(row3.get(2) == '@' && row3.get(1) == '@' && row3.get(0) == '-') 
			 	{lostCheck.add(1);}
		else if (row3.get(2) == '@' && row2.get(2) == '@' && row1.get(2) == '-')
				{lostCheck.add(1);}
		
		for(int i = 0; i <= (lostCheck.size() - 1); i++) {System.out.println(lostCheck.get(i));}
			
//BELOW CHECKS IF THERE ARE ANY POSSIBLE MOVES	 
		boolean keepGoing;
		if (lostCheck.size() > 0) {keepGoing = true;}
		else {keepGoing = false;}
		
		return keepGoing;
	}
	
	
	public static void main(String[] args) {
		PegGame game1 = new PegGame();

//Start of game		
		System.out.println("Welcome to Peg Solitaire!");
		game1.createBoard();
		game1.printBoard();
		
//the first move		
		System.out.println("Select a peg by entering the row followed by the column. "
				+ "Example \"3 1\" would select the bottom left peg ");
		game1.firstMove();
		game1.printBoard();
		
//all subsequent moves		
		while (game1.moveOptions()) {
		game1.MoveStart();
		game1.printBoard();
		game1.gameWin();}
		
		

	}

}
