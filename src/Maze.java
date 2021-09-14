import java.lang.reflect.Array;
import java.util.Stack;

public class Maze {
    public static boolean ok; //return through the recursive statements
    static State initialState = new State(3,3,'s');
    public static char goal ='g';
    static int layerOfSearch = 0;
    int[] startCoords ={3,3}; // Lokation af 's'
    //State [][] allStates; // array of alle possible states //bad idea
    public static boolean[][] possiblePath = new boolean[10][13]; //Array of visited or impossible spaces. Where to look
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
    public static Stack<State> stepTracer = new Stack<State>();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 13; j++) {
                if (maze[i][j] == 11035 || maze[i][j] == 's')
                    possiblePath[i][j] = false;
                else if (maze[i][j] == 11036 || maze[i][j] == 'g')
                    possiblePath[i][j] = true;
            }
        }// laver et 2d array over de mulige fetler man kan gå på

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 13; j++) {
//                System.out.print(possiblePath[i][j]);
//            }
//            System.out.println("");
//        }// print

        //add starting node

        initialState.setLocationX(3);
        initialState.setLocationY(3);
        initialState.setMyField('s');

        stack.push(initialState);
        System.out.println("Main initial state" + initialState.getLlocationY()); //todo slet
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

        //create possible substates in the 4 directions
        for (int i = 0; i < 4; i++) {


            if (possiblePath[s.getLlocationX()][s.getLlocationY()+1]) {//step north
                stack.push(new State(s.getLlocationX(),s.getLlocationY()+1,maze[s.getLlocationX()][s.getLlocationY()+1])); //push mulig state til stacken
                possiblePath[s.getLlocationX()][s.getLlocationY()+1] = false;
            }
            if (possiblePath[s.getLlocationX()+1][s.getLlocationY()]){//step east
                stack.push(new State(s.getLlocationX()+1,s.getLlocationY(),maze[s.getLlocationX()+1][s.getLlocationY()])); //push mulig state til stacken
                possiblePath[s.getLlocationX()+1][s.getLlocationY()] = false;
            }
            if (possiblePath[s.getLlocationX()][s.getLlocationY()-1]){//step south
                stack.push(new State(s.getLlocationX(),s.getLlocationY()+1,maze[s.getLlocationX()][s.getLlocationY()-1])); //push mulig state til stacken
                possiblePath[s.getLlocationX()][s.getLlocationY()-1] = false;
            }
            if (possiblePath[s.getLlocationX()-1][s.getLlocationY()]){//step west
                stack.push(new State(s.getLlocationX()-1,s.getLlocationY(),maze[s.getLlocationX()-1][s.getLlocationY()])); //push mulig state til stacken
                possiblePath[s.getLlocationX()-1][s.getLlocationY()] = false;
            }

            State newState = stack.pop();
            System.out.println("new stateX " + newState.getLlocationX());
            System.out.println("new statey " + newState.getLlocationY());
            ok = search(newState);
            if (ok){
                System.out.println("Found goal");
                return true;
            }

        }
        return false;

    }




}
