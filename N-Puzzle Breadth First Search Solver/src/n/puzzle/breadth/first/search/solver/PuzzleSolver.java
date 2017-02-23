/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.puzzle.breadth.first.search.solver;

/**
 *
 * @author Willow
 */
import java.util.*;

public class PuzzleSolver {

    /**
     * @param args the command line arguments
     */
    //Creating a queue for the arrays to be added below
    public static Integer[] goal = new Integer[9];//contains the goal state for
    //comparison
    
    /***DEPTH LEVEL TRACKING VARIABLES ***/
   
    public static Integer[] root = new Integer[9]; //this will contain the
    //initial root node. 
  
    
    public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
   
    
    //Note that the array's length has been set to 9 to make sure that the input
    //accustoms to the 8-puzzle parameters
    
    
    /*** 
     * OBTAINING ROOT STATE FROM USER
     * 
     ***/
    
    System.out.println("Enter you initial state: ");
    for(int i=0; i<root.length;i++){ 
        int rootnum = sc.nextInt(); //storing the user's input to use for 
        //boolean checks
        if (rootnum < 9 && !Arrays.asList(root).contains(rootnum)){ //Checks if 
            //the number can fit in the 8-puzzle and removes repeats
        root[i] = rootnum;
        }else {
            System.out.println("Please enter a number between 0 and 8,\r\n"
                    + "which you haven't already entered: ");
            i--;//resets the value so a value can be assigned to the same 
            //position again.
        }
    }
    System.out.println("Your initial state is: ");
    as3x3(root);
    
    //queue.add(root); //adds the root node to the queue
    
    /**
     * OBTAINING GOAL STATE FROM USER
     */
    
    System.out.println("Enter your goal state:");
    for(int j=0; j<goal.length;j++){ 
        int goalnum = sc.nextInt();//Same use as outlined in line 44.
        if (goalnum < 9 && !Arrays.asList(goal).contains(goalnum)){
             goal[j]= goalnum;
        } else {
            System.out.println("Please enter a number between 0 and 8, \r\n"
                    + "which you have not already entered: ");
            j--;
        }   
    }
    sc.close();//Closes the scanner
    System.out.println("Your goal state is: ");
     as3x3(goal);
    
    Solver solvePuzzle = new Solver(root,goal);//Instance of solver to create 
    //goal.
    solvePuzzle.SearchNode(goal);
    }
    
 /***PRINTING OUT THE ARRAYS AS A 3X3 MATRIX/ PUZZLE ***/
    public static void as3x3(Integer[] array){
       
        StringBuilder builder = new StringBuilder();
        for(Integer value : array){
            builder.append(value);
        }
       
        String puzzle = builder.toString(); 
            
           try{
                for(int m = 0; m < puzzle.length(); m++){ //For spacing out 
                    //the values and printing a new line at every 3rd value.
                    System.out.print(" " +String.valueOf(puzzle.charAt(m) + " ")
                    );
                     if((m+1)%3 == 0){
                         System.out.println(); 
                     }
                }
            } 
            catch (NullPointerException e){}
    }
}
