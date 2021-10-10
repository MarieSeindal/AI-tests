import java.lang.reflect.Array;
import java.util.Stack;

public class Maze {
    public static boolean ok; //return through the recursive statements
    static State initialState = new State(3,3,'s');
    static int layerOfSearch = 0;
    public static boolean[][] possiblePath = new boolean[10][13]; //Array of visited or impossible spaces. Where to look

    //Get maze coords: maze[y][x]
    public static char[][] maze = {
            {11035,11035,11035,11035,11035,11035,11035,11035,11035,11035,11035,11035,11035},
            {11035,11036,11035,11036,11035,11036,11035,11036,11036,11036,11036,11036,11035},
            {11035,11036,11035,11036,11036,11036,11035,11036,11035,11035,11035,11036,11035},
            {11035,11036,11036,'s',11035,11035,11035,11036,11036,11036,11036,11036,11035},
            {11035,11036,11035,11036,11036,11036,11036,11036,11035,11035,11035,11036,11035},
            {11035,11036,11035,11036,11035,11035,11035,11036,11035,11036,11036,11036,11035},
            {11035,11036,11035,11036,11035,11036,11036,11036,11035,11035,11035,11036,11035},
            {11035,11036,11035,11036,11035,11035,11035,11036,11035,11036,11035,11036,11035},
            {11035,11036,11036,11036,11036,11036,11036,11036,11036,11036,11035,'g',11035},
            {11035,11035,11035,11035,11035,11035,11035,11035,11035,11035,11035,11035,11035}}; //w = wall, p=path

    public static Stack<State> stack = new Stack<State>();
    public static Stack<State> stepTracer = new Stack<State>(); //

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 13; j++) {
                if (maze[i][j] == 11035 || maze[i][j] == 's')
                    possiblePath[i][j] = false;
                else if (maze[i][j] == 11036 || maze[i][j] == 'g')
                    possiblePath[i][j] = true;
            }
        }// laver et 2d array over de mulige fetler man kan gå på

        initialState.setLocationX(3);
        initialState.setLocationY(3);
        initialState.setMyField('s');

        stack.push(initialState);
        search(initialState);


        for (char[] a : maze) {
            for (char b: a) {
                System.out.print(b);
            }
            System.out.println("");
        }// print maze
    }

    public static boolean search(State s) {//bool Search(State s)
        layerOfSearch++;
        System.out.println("Lag i søgningen " + layerOfSearch);

        if(s.getMyField() == 'g') {//  if we are on goal
            System.out.println("Goal fundet");
            return true;
        }

            if (possiblePath[s.getLlocationY()-1][s.getLlocationX()]) {//step north
                stack.push(new State(s.getLlocationX(),s.getLlocationY()-1,maze[s.getLlocationY()-1][s.getLlocationX()])); //push mulig state til stacken
                possiblePath[s.getLlocationY()-1][s.getLlocationX()] = false;
            }
            if (possiblePath[s.getLlocationY()][s.getLlocationX()-1]){//step west
                stack.push(new State(s.getLlocationX()-1,s.getLlocationY(),maze[s.getLlocationY()][s.getLlocationX()-1])); //push mulig state til stacken
                possiblePath[s.getLlocationY()][s.getLlocationX()-1] = false;
            }
            if (possiblePath[s.getLlocationY()+1][s.getLlocationX()]){//step south
                stack.push(new State(s.getLlocationX(),s.getLlocationY()+1,maze[s.getLlocationY()+1][s.getLlocationX()])); //push mulig state til stacken
                possiblePath[s.getLlocationY()+1][s.getLlocationX()] = false;
            }
            if (possiblePath[s.getLlocationY()][s.getLlocationX()+1]){//step east
                stack.push(new State(s.getLlocationX()+1,s.getLlocationY(),maze[s.getLlocationY()][s.getLlocationX()+1])); //push mulig state til stacken
                possiblePath[s.getLlocationY()][s.getLlocationX()+1] = false;
            }


            State newState = stack.pop();
            System.out.println("new stateX " + newState.getLlocationX());
            System.out.println("new statey " + newState.getLlocationY());

        //System.out.println("Allowed? " + possiblePath[newState.getLlocationY()][newState.getLlocationX()]);

            ok = search(newState);
            if (ok){
                System.out.println("Found goal");
                return true;

        }
        return false;

    }




}
