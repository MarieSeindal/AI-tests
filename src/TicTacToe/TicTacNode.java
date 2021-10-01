package TicTacToe;

import java.util.ArrayList;

public class TicTacNode { //see pptx and yt
    TicTacNode parent;
    int value;
    int alpha;
    int beta;
    TicState gameState;

    ArrayList<TicTacNode> children;

    public TicTacNode(TicState gameState) {
        children = new ArrayList<>();
        this.gameState = gameState;

    }



}
