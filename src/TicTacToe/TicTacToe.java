package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    static boolean continueGame = true;
    public static boolean gameOver = false;
    static boolean pvp = false; //standard vs AI
    static char player1;
    static char player2;
    public static char currentPlayer = player1; //standard start med spiller 1, som x
    static Scanner scanner = new Scanner(System.in);
    public static int maxDepth;
    static int bestMoveScore =-100;

    // 2d Array med point
    static int[][] points ={{3,2,3},{2,4,2},{3,2,3}};

    // 2d boolean Array with vacant fields
    static boolean[][] vacantField ={{true,true,true},{true,true,true},{true,true,true}};

    // 2d array with the board as it is, space = vacant, x=p1, o=p2, A=any
    static char[][] currentBoard ={{9634,9634,9634},{9634,9634,9634},{9634,9634,9634}};
    static char[][] startState ={{9634,9634,9634},{9634,9634,9634},{9634,9634,9634}};
    static TicState bestMove; // Record the best state during algorithm

    public static void main(String[] args) {
        String userInput;
        Scanner scan = new Scanner(System.in);

        while (continueGame){
            initGame();

            char[][] test ={{'x',9634,9634},{9634,'x',9634},{9634,9634,9634}};
            TicState test1 = new TicState(test);


            play();

            System.out.println("Play again?\ny/n");
            userInput = scan.nextLine();
            userInput.toLowerCase();
            if (userInput.equals("n")) {
                continueGame = false;
                System.out.println("GG! \nEnd of game(s)");
                scan.close();
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

                    // create starting node
                    TicState stateToSearch = new TicState(currentBoard);
                    TicTacNode search = new TicTacNode(stateToSearch);

                    bestMoveScore = -100; // reset the score

                    minimax(search,0,true,-1000000, +1000000);//nodeToSearch, 0=depth, true =isMax, alpha, beta

                    int[] extractedMove = extractMoveFromMinimax(); //extract move

                    currentBoard[extractedMove[0]][extractedMove[1]] = currentPlayer;
                    vacantField[extractedMove[0]][extractedMove[1]] = false;
                }

            }
            // victory or death?
            switch (endGame(currentBoard)){
                case 0: //Board not full
                    break;
                case 1: //x won
                    if (player1 == 'x')
                        System.out.println("Player 1 won this game!");
                    else
                        System.out.println("Player 2 won this game!");
                    gameOver = true;
                    break;

                case 2: //o won
                    if (player1 == 'o')
                        System.out.println("Player 1 won this game!");
                    else
                        System.out.println("Player 2 won this game!");
                    gameOver = true;
                    break;

                case 3: // board full
                    System.out.println("Board full \nNo winner");
                    gameOver = true;
                    break;
            }

            // Switch players
            if (currentPlayer == player1) {
                currentPlayer = player2;
            }else
                currentPlayer = player1;
        }
    }

    public static int[] extractMoveFromMinimax(){ // compares current board with best move and returns coordinate to best move
        int[] moveFound = {0,0}; //todo

        int rows=0;
        for (char[] row : bestMove.getPlacedPieces()) {
            int column=0;
            for (char field : row) {

                if (!(field == currentBoard[rows][column])){ //Backup: betterMove.getPlacedPieces[rows][column]
                    moveFound[0] = rows;
                    moveFound[1] = column;
                }
                column++;
            }
            rows++;
        }
        return moveFound;
    }

    public static int minimax (TicTacNode nodeTosearch, int depth, boolean isMax, int alpha, int beta){
        //Useful links
        //https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-4-alpha-beta-pruning/
        //https://www.geeksforgeeks.org/multidimensional-arrays-in-java/
        System.out.println("Depth in minimax "+depth); //todo

        // If leaf node, return static value of the board
        if (depth == maxDepth){ // leaf
            return (evaluateLeaf(nodeTosearch.getState()));
        }

        //man starter på depth 0. Node 0 er da max.
        else if (depth%2 == 0){ // node in depth 0,2 ... straight numbers is max, as the algorithm runs the players turn.
            int bestValue = alpha;
            int value;

            fillChildren(nodeTosearch); //Ad children to the parents arraylist

            for (TicTacNode child : nodeTosearch.getChildren()) {
                value = minimax(child,depth+1,false,alpha,beta);
                bestValue = max(bestValue , value);
                alpha = max(alpha , bestValue);

                if(beta <= alpha)
                    break;
            }
            return bestValue;
        }
        else if (depth%2 == 1){ // node in depth 1,3 ... unequal numbers is min, as the algorithm runs the opponents turn.
            int bestValue = beta;
            int value;

            for (TicTacNode child : nodeTosearch.getChildren()) {
                value =minimax(child, depth+1, true, alpha, beta);
                bestValue = min(bestValue , value);
                beta = min(beta , bestValue);

                if (depth == 1){ //Todo attempt to record best move. Maybe works?
                    System.out.println("Hurray we made it into if depth = 1 ");
                    int calculateScore = evaluateLeaf(nodeTosearch.getState());
                    if ( calculateScore > bestMoveScore){
                        System.out.println("Hurray we made it into if calculate score ");
                        bestMoveScore = calculateScore;
                        bestMove.setPlacedPieces(nodeTosearch.getState().getPlacedPieces());
                    }
                }

                if (beta <= alpha)
                    break;

            }
            return bestValue;
        }

        return 0;
    }

    public static void fillChildren(TicTacNode parent){

        int vacantFields=0;  //For each vacant field, there is an option/child. This count the amounts of children, because why not?

        char[][] boardParent = parent.getState().getPlacedPieces();
        System.out.println("Board parent: " + boardParent.toString());

        int rows=0;
        for (char[] row :boardParent) {
            int column=0;

            for (char field :row) {

                if (vacantField[rows][column]) {//If field is vacant, there can be added a child for that move.

                    vacantFields++;
                    TicTacNode copy = parent.clone(); //make copy
                    copy.getState().setSinglePiece(rows,column,currentPlayer); // Make the vacant move
                    parent.addChildren(copy); //add child to the arraylist
                }

                column++;
            }
            rows++;
        }
    }

    public static int max(int a, int b){
        if (a>b)
            return a;
        else return b;
    }

    public static int min(int a, int b){
        if (a<b)
            return a;
        else return b;
    }

    public static int evaluateLeaf(TicState stateToScore){

        // count the players character as negative
        // count the AI's character as positive.

        int currentScore =0;

        char[][] scoreFind = stateToScore.getPlacedPieces(); //get the char [][] board

        int row=0;
        for (char[] array : scoreFind) {
            int column = 0; //for each row we check the first, second and third collum spot.
            for (char field: array) {

                if (field == 9634){ //if field is blank
                }
                else if (field == currentPlayer){ //if it is the current players turn
                    currentScore += points[row][column];
                }
                else { // the oponent
                    currentScore -= points[row][column];
                }
                column++;
            }
            row++;
        }

        return currentScore;
    }

    public static void makeMove(){

        String printPlayer;
        if(currentPlayer == player1)
            printPlayer = "1";
        else printPlayer = "2";

        System.out.println("Player " + printPlayer + " choose your move");
        int inputInt = scanner.nextInt();
        boolean takenField = false;
        if (inputInt >=1 && inputInt <=3){ //Row 1
            if (!(vacantField[0][inputInt-1])){ //if field is not vacant
                takenField = true;
            }else {
                currentBoard[0][inputInt - 1] = currentPlayer;
                vacantField[0][inputInt - 1] = false;}

        }else if(inputInt >=4 && inputInt <=6){ //Row 2
            if (!(vacantField[1][(inputInt-1)%3])){
                takenField = true;
            }else {
                currentBoard[1][(inputInt - 1) % 3] = currentPlayer;
                vacantField[1][(inputInt - 1) % 3] = false;}

        }else if(inputInt >=7 && inputInt <=9){ //Row 3
            if (!(vacantField[2][(inputInt-1)%3])){
                takenField = true;
            }else {
                currentBoard[2][(inputInt - 1) % 3] = currentPlayer;
                vacantField[2][(inputInt - 1) % 3] = false;}
        }

        //Player makes move
        while (takenField){ //If the player entered an illegal spot, loop until a valid spot is chosen.
            System.out.println("That spot is taken. Player " + printPlayer + " choose a new move");
            inputInt = scanner.nextInt();
            if (inputInt >=1 && inputInt <=3){
                if (vacantField[0][inputInt-1]) { //if spot is taken, you made a wrong choice
                    currentBoard[0][(inputInt - 1) % 3] = currentPlayer;
                    vacantField[0][(inputInt - 1) % 3] = false;
                    takenField = false;
                }
            }else if(inputInt >=4 && inputInt <=6){
                if (vacantField[1][(inputInt-1)%3]){
                    currentBoard[1][(inputInt - 1) % 3] = currentPlayer;
                    vacantField[1][(inputInt - 1) % 3] = false;
                    takenField = false;
                }
            }else if(inputInt >=7 && inputInt <=9){
                if (vacantField[2][(inputInt-1)%3]){
                    currentBoard[2][(inputInt - 1) % 3] = currentPlayer;
                    vacantField[2][(inputInt - 1) % 3] = false;
                    takenField = false;
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

    public static int endGame(char[][] currentState){

        //check current player
        if (checkPlayerWon(currentState)){
            //System.out.println("Player" + currentPlayer + " have won");
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

    static boolean checkPlayerWon(char[][] currentState){
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
