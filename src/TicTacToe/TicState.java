package TicTacToe;

import java.io.Serializable;

public class TicState implements Serializable {

    char [][] placedPieces;

    public TicState(char[][] stateInput){
        placedPieces = stateInput;
    }

    public char[][] getPlacedPieces() {
        return placedPieces;
    }
    public void setPlacedPieces(char[][] placedPieces) {
        this.placedPieces = placedPieces;
    }

    public void setSinglePiece(int row, int column,char field){
        this.placedPieces [row][column] = field;
    }

}
