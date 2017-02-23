/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n.puzzle.breadth.first.search.solver;

    /***************************************************************************
     *************************************************************************
     * 
     * 
     ***************************METHODS***************************************
     ************************************************************************ 
     * 
     *
     **************************************************************************
     **************************************************************************/
 
import java.util.*;
public class Solver {
     Queue<Integer[]> queue ;
     //contains the goal state for comparison
    
    /***DEPTH LEVEL TRACKING VARIABLES ***/
    int nodes = 0;
    int uniqueNodes = -1; //because the root is being added
    int depth; //For counting node generation
    
    Map<Integer[],Integer> depthLevel ;//will allow recognition of the depth 
    //level being explored
    Map<Integer[],Integer[]> stateHistory ;//stores the current state and 
    //its parent.
    
    boolean solution = false; //For seeing if the solution has been found
    
    public Solver (Integer[] curr, Integer[] goal){
        queue = new LinkedList<>();
        depthLevel = new HashMap<>();
        stateHistory = new HashMap<>();
        
        addToQueue(curr,null);//this is so that the queue solver can start 
        //search effectively.
    }
    
    
       
    /*SWAP FUNCTION FOR ARRAY VALUES SWAPPING */
    public static final <T> void swap (Integer[] a, Integer i, Integer j) {
        Integer t = a[i];
        a[i] = a[j];//assigns the value in position j to position i
        a[j] = t; //then reassigns the last value with the original value of 
        //i to that in position j
}

/* TESTING METHOD FOR SWAP FUNCTION 
private static void test() {
  int [] a = {0,1};
  swap(a, 0, 1);
  System.out.println("a:"+Arrays.toString(a));
}*/
    
     void SearchNode(Integer[] finalState){
        
       Integer[] currentState; //Holds the current node to be expanded.
       while(!queue.isEmpty()){
           currentState = queue.remove(); //Holds the current node to be 
           //expanded.
           if(Arrays.equals(currentState,finalState)){
               solution = true;
               printSolution(currentState); //Printing the solution
               break; //breaks out of the while loop once solution is found 
           } 
          
            possibleMoves(currentState); //expands the current state and adds 
            //the node to the queue. 

       }
      
       if(solution){
           System.out.println("A Solution Exists!"); //stating the obvious
       } else {
           System.out.println("Solution has not been found yet. It may be "
                   + "impossible for this graph");
       }
    
   }
    
    private  void addToQueue(Integer[] child, Integer[] parent){
        if(!depthLevel.containsKey(child)){ //checks to ensure that the state 
            //is not being repeated through the search
            depth = parent == null ? 0 : depthLevel.get(parent)+1; //checks if 
            //the comparison for the depth int value and the parent equates to 
            //a null value. Then assigns 0 if true and then adds one if not.
            uniqueNodes++;
            depthLevel.put(child,depth);
            queue.add(child);//Adds the node to the end of the opened list
            stateHistory.put(child, parent);
        }
    }
    
     void printSolution (Integer[] currentState){
        if(solution){
            int finalDepth = depthLevel.get(currentState);//simply a store for getting teh pasition of current state
            System.out.println("Solution found in " + finalDepth + " step(s)");
            //Prints out the number of steps that it will take following this 
            //solution path.
            System.out.println("Nodes generated: "+nodes); //Number of nodes 
            //generated.
            System.out.println("Unique nodes generated: "+uniqueNodes); //Unique
            //nodes found.
        } 
        
        Integer [] asArray = currentState;
        //traceState = traceState.replace(",","").replace("[","")
        //.replace("]","").trim();
        
        
        //For printing out the graph
        while(asArray != null){
        /*transforming array to string */
        StringBuilder builder = new StringBuilder();
        for(Integer value : asArray){
            builder.append(value);
        }
       
        String traceState = builder.toString(); 
            System.out.println(traceState + " at depth " +
                    depthLevel.get(asArray));
            
            //Creating the 3x3 Representation
           try{
                for(int m = 0; m < traceState.length(); m++){ //For spacing out
                    //the values and printing a new line at every 3rd value.
                    System.out.print(" " +String.valueOf(traceState.charAt(m) +
                            " "));
                     if((m+1)%3 == 0){
                         System.out.println(); 
                     }
                }
            } 
            catch (NullPointerException e){}
            asArray = stateHistory.get(asArray);
        }
        
        
    }
    
    /** DETERMINING WHAT MOVES CAN BE MADE AT POSITIONS IN THE ARRAY **/
     void possibleMoves(Integer[] arr){
       Integer[] nodeArray = Arrays.copyOf(arr, 9);
       List arrList = Arrays.asList(Arrays.copyOf(arr, 9));/*Only way I can 
       //apparently get the index of my blank value without changing the entire
       actual value
       //Arrays do not work by reference so changing the core value of an array 
       even when mapped to another will change the original array's value. 
       //Thus copy of arrrays were made in order to be able to expand the nodes
       correctly*/
       int a = arrList.indexOf(0);//Allows me to identify the position of the
       //blank
       /**DETERMINING VALUES OF MOVEMENT **/
       int l = a - 1;//left
       int u = a -3;//up
       int r = a +1;//right
       int d = a +3;//down
               
       /** TESTING BLANK POSITION IDENTIFICATION
       System.out.println("Index of root node is: ");
       System.out.println(a);
      **/
       /**MOVING LEFT**/
       while(a!=0 && a!=3 && a!=6 ){ //Ensures that at given positions,
           //the following moves CANNOT be made.
           swap(nodeArray, a, l);//uses the swap function created 
           //earlier to swap the values around. 
           addToQueue(nodeArray,arr);
           nodeArray = Arrays.copyOf(arr, 9);
           nodes++;
           break;
       }
       
       /**MOVING BLANK UP**/
       while(a!=0 && a!=1 && a!=2 ){
           swap(nodeArray, a, u);
           addToQueue(nodeArray,arr);
           nodeArray = Arrays.copyOf(arr, 9);
           nodes++;
           break;
       }
       
       
       /**MOVING BLANK RIGHT**/
       while(a!=2 && a!=5 && a!=8){//PREVENTS RIGHT MODES NODES FROM MOVING 
           //RIGHT
           swap(nodeArray, a, r);
           addToQueue(nodeArray,arr);
           nodeArray = Arrays.copyOf(arr, 9);
           nodes++;
           break;
       }
       
       /**MOVING BLANK DOWN**/
       while(a!=6 && a!=7 && a!=8 ){
           swap(nodeArray, a, d);
           addToQueue(nodeArray,arr);
           nodeArray = Arrays.copyOf(arr, 9);
           nodes++;
           break;
       }
       
    }
}

