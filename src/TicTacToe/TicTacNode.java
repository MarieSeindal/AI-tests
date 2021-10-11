package TicTacToe;

import java.io.*;
import java.util.ArrayList;

public class TicTacNode implements Serializable { //see pptx and yt
    TicState state;
    ArrayList<TicTacNode> children;

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

    public TicTacNode clone() { //todo tjek op på hvilke klasser der skal være serialisable
        TicTacNode obj = null;
        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(this);
            out.flush();
            out.close();

            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(
                    new ByteArrayInputStream(bos.toByteArray()));
            obj = (TicTacNode) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }




}
