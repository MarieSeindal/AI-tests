import java.lang.reflect.Array;
import java.util.Stack;

public class Maze {

    State initialState;
    public static char goal ='g';
    int[] startCoords ={3,3}; // Lokation af 's'
    //State [][] allStates; // array of alle possible states //bad idea
    public static boolean[][] possiblePath = new boolean[13][10]; //Array of visited or impossible spaces. Where to look
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
        boolean[][] testedPath;



        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 10; j++) {
                if (maze[i][j] == 11035)
                    possiblePath[i][j] = false;
                else if (maze[i][j] == 11036 || maze[i][j] == 'g')
                    possiblePath[i][j] = true;
            }
        }// laver et 2d array over de mulige fetler man kan gå på

        for (char[] a : maze) {
            for (char b: a) {
                System.out.print(b);
            }
            System.out.println("");
        }// print maze
    }

    public static boolean Search(State s) {//bool Search(State s)

        if(s.getMyField() == 'g')//  if s==Goal
            return true;

        for (int i = 0; i < 4; i++) {

            if (possiblePath[s.getLlocationX()][s.getLlocationY()+1]) {//step north
                stack.push(new State(s.getLlocationX(),s.getLlocationY()+1,maze[s.getLlocationX()][s.getLlocationY()+1])); //push mulig state til stacken
            }
            if (possiblePath[s.getLlocationX()+1][s.getLlocationY()]){//step east
                stack.push(new State(s.getLlocationX()+1,s.getLlocationY(),maze[s.getLlocationX()+1][s.getLlocationY()])); //push mulig state til stacken
            }
            if (possiblePath[s.getLlocationX()][s.getLlocationY()-1]){//step south
                stack.push(new State(s.getLlocationX(),s.getLlocationY()+1,maze[s.getLlocationX()][s.getLlocationY()-1])); //push mulig state til stacken
            }
            if (possiblePath[s.getLlocationX()-1][s.getLlocationY()]){//step west
                stack.push(new State(s.getLlocationX()-1,s.getLlocationY(),maze[s.getLlocationX()-1][s.getLlocationY()])); //push mulig state til stacken
            }

            State newState = stack.pop();


            boolean ok; //return through the recursive statements

            //create possible substates
            // and search through them



        }
        return false;

        //  for each substate si
        //    OK=Search(si)
        //    if OK
        //      return true
        //  return false

        //Tilføj forbundede felter til der hvor du står

        //Pop og Tjek feltet du står på

        //Search next


    }




}
