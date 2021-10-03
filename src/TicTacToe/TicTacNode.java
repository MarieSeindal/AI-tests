package TicTacToe;

import java.util.ArrayList;

public class TicTacNode { //see pptx and yt
    TicTacNode parent;
    int value;
    int alpha;
    int beta;
    TicState state;
    ArrayList<TicTacNode> children;

    private TicTacNode(TicState gameState) {
        children = new ArrayList<>();
        state = gameState;

    }

    public TicTacNode getParent(){
        return parent;
    }
    public void setParent(TicTacNode parent){
        this.parent = parent;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public int getAlpha() {
        return alpha;
    }
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
    public int getBeta() {
        return beta;
    }
    public void setBeta(int beta) {
        this.beta = beta;
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
    public void setChildren(ArrayList<TicTacNode> children) {
        this.children = children;
    }




}
