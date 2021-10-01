package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    static boolean continueGame = true;
    public static boolean gameOver = false;
    static boolean pvp = false; //assumed vs AI
    static char player1;
    static char player2;
    public static char currentPlayer = player1; //standard start med spiller 1, som x
    static Scanner scanner = new Scanner(System.in);
    static String userInput;

    // 2d Array med point
    static int[][] points ={{3,2,3},{2,4,2},{3,2,3}};

    // 2d boolean Array med ledige pladser
    static boolean[][] vacantField ={{true,true,true},{true,true,true},{true,true,true}};

    // 2d array with the board as it is, space = vacant, x=p1, o=p2, A=any
    static char[][] currentBoard ={{9634,9634,9634},{9634,9634,9634},{9634,9634,9634}};
    static char[][] startState ={{9634,9634,9634},{9634,9634,9634},{9634,9634,9634}};

    public static void main(String[] args) {

        while (continueGame){
            initGame();

            play();

            System.out.println("Play again?\ny/n");
            userInput = scanner.nextLine();
            userInput.toLowerCase();
            if (userInput.equals("n")) {
                System.out.println("User debug "+userInput);
                continueGame = false;
                System.out.println("GG! \nEnd of game");
            }
            else {
                currentBoard = startState;
            }

        }

    }


    static void initGame(){ //Prompt the player for some settings.
        System.out.println("Welcome to Tic Tac Toe!" );
        System.out.println("Please choose: \n 1: Player vs AI \n 2: Player vs Player");
        String userInput = scanner.nextLine();

        if(userInput.equals("1")){
            pvp = false;
        }
        else if (userInput.equals("2")){
            pvp = true;
        }

        //Choose sides
        System.out.println("Player 1 choose either x or o");
        userInput = scanner.nextLine();
        userInput.toLowerCase();
        if(userInput.equals("x")){
            System.out.println("Player 1 is x. \nPlayer 2 is o\n");
            player1 = 'x';
            player2 = 'o';
            currentPlayer = player1;
        }
        else if (userInput.equals("o")){
            System.out.println("Player 1 is o.\nPlayer 2 is x\n");
            player1 = 'o';
            player2 = 'x';
            currentPlayer = player2;
        }

        //tutorial
        System.out.println("In order to place a piece on the board, you need to type the number corresponding to the desired location.\nThe locations are:");
        System.out.println("1,2,3\n4,5,6\n7,8,9\n");

    }

    static void play(){
        while (!gameOver){

            if(pvp){ //PvP game
                makeMove();
                printGameBoard();
            }
            else{//PvAI game
                if (currentPlayer == player1) { // if AI is o, this is the players turn.
                    makeMove();
                    printGameBoard();
                }else { // if AI is x

                }


                //if player 2's turn (AI)
                    // Calculate move with alhpa beta min max
                    // make move
            }

            // victory or death?
            if (!(EndGame(currentBoard) == 0)){ //if board full or victory, game-over is true.
                gameOver = true;
            }

            // Switch players
            if (currentPlayer == player1) {
                currentPlayer = player2;
            }else
                currentPlayer = player1;

            //break; //todo debug remove

        }
    }

    /*
    //return 0 for no ending, 1 for x won, 2 for o won, 3 for full board
    */

    public static void makeMove(){

        String printPlayer;
        if(currentPlayer == player1)
            printPlayer = "Player 1";
        else printPlayer = "Player 2";

        System.out.println("Player " + printPlayer + " choose your move");
        int inputInt = scanner.nextInt();
        boolean wrongChoice = false;
        if (inputInt >=1 && inputInt <=3){ //Row 1
            if (!(vacantField[0][inputInt-1])){ //if field is not vacant
                wrongChoice = true;
            }else {
                currentBoard[0][inputInt - 1] = currentPlayer;
                vacantField[0][inputInt - 1] = false;
            }


        }else if(inputInt >=4 && inputInt <=6){ //Row 2
            if (!(vacantField[1][(inputInt-1)%3])){
                wrongChoice = true;
            }else {
                currentBoard[1][(inputInt - 1) % 3] = currentPlayer;
                vacantField[1][(inputInt - 1) % 3] = false;
            }

        }else if(inputInt >=7 && inputInt <=9){ //Row 3
            if (!(vacantField[2][(inputInt-1)%3])){
                wrongChoice = true;
            }else {
                currentBoard[2][(inputInt - 1) % 3] = currentPlayer;
                vacantField[2][(inputInt - 1) % 3] = false;
            }
        }

        //Player makes move
        while (wrongChoice){ //If the player entered an illegal spot, loop until a valid spot is chosen.
            System.out.println("That spot is taken. Player " + printPlayer + " choose a new move");
            inputInt = scanner.nextInt();
            if (inputInt >=1 && inputInt <=3){
                if (!(vacantField[0][inputInt-1])){ //if spot is taken, you made a wrong choice
                    wrongChoice = true;
                }else {
                    currentBoard[0][(inputInt - 1) % 3] = currentPlayer;
                    vacantField[0][(inputInt - 1) % 3] = false;
                }
            }else if(inputInt >=4 && inputInt <=6){
                if (!(vacantField[1][(inputInt-1)%3])){
                    wrongChoice = true;
                }else {
                    currentBoard[1][(inputInt - 1) % 3] = currentPlayer;
                    vacantField[1][(inputInt - 1) % 3] = false;
                }
            }else if(inputInt >=7 && inputInt <=9){
                if (!(vacantField[2][(inputInt-1)%3])){
                    wrongChoice = true;
                }else {
                    currentBoard[2][(inputInt - 1) % 3] = currentPlayer;
                    vacantField[2][(inputInt - 1) % 3] = false;

                }
            }
        }

    }

    static void printGameBoard(){
        for (char[] row: currentBoard) {
            for (char field:row) {
                System.out.print(field);
            }
            System.out.println("");
        }
    }

    public static int EndGame(char[][] currentState){

        //check current player
        if (checkPlayerwon(currentState)){
            System.out.println("Player" + currentPlayer + " have won");
            if (currentPlayer == 'x')
                return 1;
            else return 2;
        }

        // board full
        if (boardFull(currentState)) {
            return 3;
        }

        return 0;
    }

    static boolean boardFull(char[][] currentState){

        for (boolean[] a : vacantField) {
            for (boolean b : a) {
                if (b) //if a spot is vacant the board is not full
                    return false;
            }
        }

        return true;
    }

    static boolean checkPlayerwon(char[][] currentState){
        if (currentState[0][0] == currentPlayer &&
            currentState[0][1] == currentPlayer &&
            currentState[0][2] == currentPlayer) { //vandret top
            return true;
        }

        if (currentState[1][0] == currentPlayer &&
            currentState[1][1] == currentPlayer &&
            currentState[1][2] == currentPlayer) { //vandret midt
            return true;
        }
        if (currentState[2][0] == currentPlayer &&
            currentState[2][1] == currentPlayer &&
            currentState[2][2] == currentPlayer) { //vandret bund
            return true;
        }

        if (currentState[0][0] == currentPlayer &&
            currentState[1][0] == currentPlayer &&
            currentState[2][0] == currentPlayer) { //lodret venstre
            return true;
        }

        if (currentState[0][1] == currentPlayer &&
            currentState[1][1] == currentPlayer &&
            currentState[2][1] == currentPlayer) { //lodret midt
            return true;
        }
        if (currentState[0][2] == currentPlayer &&
            currentState[1][2] == currentPlayer &&
            currentState[2][2] == currentPlayer) { //lodret højre
            return true;
        }

        if (currentState[0][0] == currentPlayer &&
            currentState[1][1] == currentPlayer &&
            currentState[2][2] == currentPlayer) { //skråt ned
            return true;
        }
        if (currentState[2][0] == currentPlayer &&
            currentState[1][1] == currentPlayer &&
            currentState[0][2] == currentPlayer) { //skråt op
            return true;
        }

        return false;

    }

}
