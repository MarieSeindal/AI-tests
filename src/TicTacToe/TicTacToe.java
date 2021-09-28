package TicTacToe;

import java.util.ArrayList;

public class TicTacToe {
    public static boolean endGame = false;

    public static void main(String[] args) {
        // 2d Array med point
        int[][] points ={{3,2,3},{2,4,2},{3,2,3}};

        // 2d boolean Array med ledige pladser
        boolean[][] vacantField ={{true,true,true},{true,true,true},{true,true,true}};

        // List of victory states
        ArrayList<ticState> victoryStates = new ArrayList<ticState>(); {

        }

        // 2d array with the board as it is
        char[][] currentField ={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};


        while (!endGame){



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


}
