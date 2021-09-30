package TicTacToe;

public class ticState {

    char [][] placedPieces;

    public ticState(char[][] stateInput){
        placedPieces = stateInput;
    }

    public char[][] getPlacedPieces() {
        return placedPieces;
    }
    public void setPlacedPieces(char[][] placedPieces) {
        this.placedPieces = placedPieces;
    }

}
