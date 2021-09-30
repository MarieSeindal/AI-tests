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

    // 2d Array med point
    static int[][] points ={{3,2,3},{2,4,2},{3,2,3}};

    // 2d boolean Array med ledige pladser
    static boolean[][] vacantField ={{true,true,true},{true,true,true},{true,true,true}};

    public static void main(String[] args) {

        // 2d array with the board as it is, space = vacant, x=p1, o=p2, A=any
        char[][] startState ={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

        while (continueGame){
            initGame();

            play(startState);

            System.out.println("Play again?\ny/n");
            String userInput = scanner.nextLine();
            userInput.toLowerCase();
            if (userInput.equals("n"))
                continueGame = false;

        }



    }


    static void initGame(){ //Prompt the player for some settings.
        System.out.println("Welcome to Tic Tac Toe!");
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
        System.out.println("In order to place a piece on the board, you need to type the number corresponding to the desired location.\n The locations are:");
        System.out.println("1,2,3\n4,5,6\n7,8,9\n");

    }

    static void play(char[][] startState){
        String printPlayer;
        while (!gameOver){

            //Promt move or calculate move.

            //Make move

            if(pvp){ //PvP game
                if(currentPlayer == player1)
                    printPlayer = "Player 1";
                else printPlayer = "Player 2";

                //Player makes move
                System.out.println("Player " + printPlayer + " choose your move");
                // take input
                // Fill 2d array
            }
            else{ //PvAI game
                //if player 2's turn (AI)
                    // Calculate move with alhpa beta min max
                    // make move
            }

            // victory or death?
            if (!(EndGame(startState) == 0)){ //if board full or victory, game-over is true.
                gameOver = true;
            }

            // Switch players
            if (currentPlayer == player1) {
                currentPlayer = player2;
            }else
                currentPlayer = player1;

            break; //todo debug remove

        }
    }

    /*
    //return 0 for no ending, 1 for x won, 2 for o won, 3 for full board
    */
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
