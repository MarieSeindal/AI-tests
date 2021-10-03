package TicTacToe;

import java.util.ArrayList;

public class TicTacNode { //see pptx and yt
    TicTacNode parent;
    int value;
    TicState state;
    ArrayList<TicTacNode> children;
    String type;

    public TicTacNode(TicState gameState) {
        children = new ArrayList<>();
        state = gameState;
    }

    public TicState getState() {
        return state;
    }
    public void setState(TicState setState){
        state = setState;
    }
    public ArrayList<TicTacNode> getChildren() {
        return children;
    }

    public void addChildren(TicTacNode child) {
        this.children.add(child);
    }




}
