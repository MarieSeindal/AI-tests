import java.lang.reflect.Array;
import java.util.Stack;

public class Maze {

    State initialState;

    public static void main(String[] args) {
        boolean[][] testedPath;
        char[][] maze = {
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



        for (char[] a : maze) {
            for (char b: a) {
                System.out.print(b);
            }
            System.out.println("");

        }

    }



    public static boolean Search(State s) {

        //if (s.)

        //bool Search(State s)
        //  if s==Goal
        //    return true
        //  for each substate si
        //    OK=Search(si)
        //    if OK
        //      return true
        //  return false

        //Tilføj forbundede felter til der hvor du står



        //Pop og Tjek feltet du står på

        //Search next



        return false;
    }




}
