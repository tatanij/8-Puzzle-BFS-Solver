------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: N-Puzzle Breadth First Search Solver
PURPOSE OF PROJECT:To find the first path which leads to the solution by node expansion using breadth first search
VERSION or DATE: 1.0
HOW TO START THIS PROJECT: download using the repo link below
AUTHORS: Jasmeen Tatani 
USER INSTRUCTIONS:

open project in chosen Java IDE and click RUN

General Algorithm developed for the production of this project

//Input: initial state : 3x3 array and a goal: 3x3 array 
//Output: 3x3 array in final state matching the goal
/*** 
DEFINING VARIABLES
****/
List previous_states<array>;//will hold all arrays of previous states to show steps //mades to reach goal state
goalState[];//will hold the goal state
currentState[]; //an array that will displace the previous state in the queue order to continue the loop.
currentState[] = initialState[];
Queue< > ? initialState[ ]; 

/*****

Queue which will hold all possible states from an expansion of previous states. E.g. if starting state is A and produces states B, C, D, then B,C and D will be added to the queue and then A will be removed from the queue and then B will be explored, followed and its results will be added to the queue, followed by C’s exploration etc.

? means pushed into queue, <> means list , [] represents array
****/

while(currentState[] !== goalState[] && Queue< >  is not empty)
              Remove first element from queue;
    		if currentState[ ] is unexplored then
 			Depending on currentState.indexOf(0){
 				move left, up, down, or right;
 			}
 			Queue<> ? resulting arrays ;
 		Move array in queue queue up.
 		currentState[] = array at position 0;
Add solution path to previous_states<currentState[]> ;
//This program has large memory requirements as it keeps all generated nodes in //memory. Exponential time and space complexity.
