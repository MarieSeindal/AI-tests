public class State {
    char myField;
    int locationX;
    int locationY;
    boolean[] possiblePaths; //North east south west

    public State(int x, int y, char field) {
        locationX = x;
        locationY = y;
        myField = field;

    }

    public int getLlocationX(){
        return this.locationX;
    }
    public int getLlocationY(){
        return this.locationY;
    }
    public void setLocationX(int x){
        this.locationX=x;
    }
    public void setLocationY(int y){
        this.locationY=y;
    }

    public char getMyField(){
        return this.myField;
    }
    public void setMyField(char newfield){
        this.myField = newfield;
    }






}
