package TicTacToe;

import java.util.ArrayList;

public class TicTacToe {
    public static boolean endGame = false;
    public static ArrayList<char[][]> victoryStates = new ArrayList<char[][]>();

    // 2d Array med point
    int[][] points ={{3,2,3},{2,4,2},{3,2,3}};

    // 2d boolean Array med ledige pladser
    boolean[][] vacantField ={{true,true,true},{true,true,true},{true,true,true}};

    public static void main(String[] args) {

        // List of victory states
        char[][] vicx1 = {{'x','x','x'},{'a','a','a'},{'a','a','a'}}; //top Row
        char[][] vicx2 = {{'a','a','a'},{'x','x','x'},{'a','a','a'}}; //mid Row
        char[][] vicx3 = {{'a','a','a'},{'a','a','a'},{'x','x','x'}}; //bottom Row
        char[][] vicx4 = {{'x','a','a'},{'x','a','a'},{'x','a','a'}}; //top column
        char[][] vicx5 = {{'a','x','a'},{'a','x','a'},{'a','x','a'}}; //mid column
        char[][] vicx6 = {{'a','a','x'},{'a','a','x'},{'a','a','x'}}; //bottom column
        char[][] vicx7 = {{'x','a','a'},{'a','x','a'},{'a','a','x'}}; //skrå nedad
        char[][] vicx8 = {{'a','a','x'},{'a','x','a'},{'x','a','a'}}; //skrå opad

        char[][] vico1 = {{'o','o','o'},{'a','a','a'},{'a','a','a'}}; //top Row
        char[][] vico2 = {{'a','a','a'},{'o','o','o'},{'a','a','a'}}; //mid Row
        char[][] vico3 = {{'a','a','a'},{'a','a','a'},{'o','o','o'}}; //bottom Row
        char[][] vico4 = {{'o','a','a'},{'o','a','a'},{'o','a','a'}}; //top column
        char[][] vico5 = {{'a','o','a'},{'a','o','a'},{'a','o','a'}}; //mid column
        char[][] vico6 = {{'a','a','o'},{'a','a','o'},{'a','a','o'}}; //bottom column
        char[][] vico7 = {{'o','a','a'},{'a','o','a'},{'a','a','o'}}; //skrå nedad
        char[][] vico8 = {{'a','a','o'},{'a','o','a'},{'o','a','a'}}; //skrå opad

        victoryStates.add(vicx1);
        victoryStates.add(vicx2);
        victoryStates.add(vicx3);
        victoryStates.add(vicx4);
        victoryStates.add(vicx5);
        victoryStates.add(vicx6);
        victoryStates.add(vicx7);
        victoryStates.add(vicx8);

        victoryStates.add(vico1);
        victoryStates.add(vico2);
        victoryStates.add(vico3);
        victoryStates.add(vico4);
        victoryStates.add(vico5);
        victoryStates.add(vico6);
        victoryStates.add(vico7);
        victoryStates.add(vico8);

        // 2d array with the board as it is, space = vacant, x=p1, o=p2, A=any
        char[][] currentField ={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};


        while (!endGame){

            //if(currentField.)





        }
        //tjek for win-condition eller board full

        //Promt move or calculate move.
        //Make move



    }

    // Returns integer depending on the gamestate
    // 0 = no victory, 1 = X, 2 = O (ikke nul)
    int wonGame() {



        return 0;
    }

    boolean isEndGame(char[][] currentState){





        if (currentState[0][0] == victoryStates.get(0)[0][1] &&
            currentState[0][1] == victoryStates.get(0)[0][2] &&
            currentState[0][2] == victoryStates.get(0)[0][3]) { //vic1

        }

        // board full
        for (boolean[] a : vacantField) {
            for (boolean b : a) {
                if (b){

                }
            }

        }



        return false;

    }


}
