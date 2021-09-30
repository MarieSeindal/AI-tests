package TicTacToe;

public class TicTacToe {
    public static boolean gameOver = false;

    public static char currentplayer = 'x'; //start med spiller 1, som x

    // 2d Array med point
    static int[][] points ={{3,2,3},{2,4,2},{3,2,3}};

    // 2d boolean Array med ledige pladser
    static boolean[][] vacantField ={{true,true,true},{true,true,true},{true,true,true}};

    public static void main(String[] args) {

        // 2d array with the board as it is, space = vacant, x=p1, o=p2, A=any
        char[][] currentField ={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};


        while (!gameOver){

            //Promt move or calculate move.

            //Make move

            // victory or death?
            if (EndGame(currentField) == 0){
                //we continue game
            }

            // Switch players
            if (currentplayer == 'x') {
                currentplayer = 'o';
                continue;
            }else
                currentplayer ='x';

        }




    }


    public static int EndGame(char[][] currentState){ //return 0 for no ending, 1 for x won, 2 for o won, 3 for full board

        //check current player
        if (checkPlayerwon(currentState)){
            System.out.println("Player" + currentplayer + " have won");
            gameOver = true;
            if (currentplayer == 'x')
                return 1;
            else return 2;
        }

        // board full
        if (boardFull(currentState))

            return 3;


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
        if (currentState[0][0] == currentplayer &&
            currentState[0][1] == currentplayer &&
            currentState[0][2] == currentplayer) { //vandret top
            return true;
        }

        if (currentState[1][0] == currentplayer &&
            currentState[1][1] == currentplayer &&
            currentState[1][2] == currentplayer) { //vandret midt
            return true;
        }
        if (currentState[2][0] == currentplayer &&
            currentState[2][1] == currentplayer &&
            currentState[2][2] == currentplayer) { //vandret bund
            return true;
        }

        if (currentState[0][0] == currentplayer &&
            currentState[1][0] == currentplayer &&
            currentState[2][0] == currentplayer) { //lodret venstre
            return true;
        }

        if (currentState[0][1] == currentplayer &&
            currentState[1][1] == currentplayer &&
            currentState[2][1] == currentplayer) { //lodret midt
            return true;
        }
        if (currentState[0][2] == currentplayer &&
            currentState[1][2] == currentplayer &&
            currentState[2][2] == currentplayer) { //lodret højre
            return true;
        }

        if (currentState[0][0] == currentplayer &&
            currentState[1][1] == currentplayer &&
            currentState[2][2] == currentplayer) { //skråt ned
            return true;
        }
        if (currentState[2][0] == currentplayer &&
            currentState[1][1] == currentplayer &&
            currentState[0][2] == currentplayer) { //skråt op
            return true;
        }

        return false;

    }


}
