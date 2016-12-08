# Dynamic-Maze-generation-resolution
This program automatically generate and solve mazes. Each time you run the program, it will generate and print a new random maze and the solution. Leverages depth-first search (DFS) and breadth-first search (BFS). Include Junit test Cases.

# To generate a maze
First start with a grid of rooms with walls between them. The grid contains r rows and r columns for a total of r*r rooms. 

# Modelling a maze
Represent the maze as a graph data structure, consisting of rooms as node ADT containing nodes pointing to North South East and West Nodes.

We create a perfect maze) defined as a maze which has one and only one path from any point in the maze to any other point. This means that the maze has no inaccessible sections, no circular paths, no open areas.
We then remove interior walls to connect adjacent rooms. The difficultly in generating a perfect maze is in choosing which walls to remove. Walls should be removed to achieve the following maze characteristics:

1. Randomized
2. Single solution
3. Fully connected

This is the general algoritm used to remove walls and generate a perfect maze.

create a CellStack (LIFO) to hold a list of cell locations<br>
set TotalCells= number of cells in grid<br>
choose the starting cell and call it CurrentCell<br>
set VisitedCells = 1<br>
while VisitedCells < TotalCells<br>
find all neighbors of CurrentCell with all walls intact<br>
if one or more found choose one at random<br>
knock down the wall between it and CurrentCell<br>
push CurrentCell location on the CellStack<br>
make the new cell CurrentCell<br>
add 1 to VisitedCells<br>
else<br>
pop the most recent cell entry off the CellStack<br>
make it CurrentCell<br>

We eliminate recursion by the using a stack

# Solving the Maze:
After generating a maze, the program solves the maze (finds a path from the starting room to the finishing room)
1. using DFS and
2. using BFS.
Each search algorithm will begin at the starting room and search for the finishing room by traversing wall openings. The search terminates as soon as the finishing room is found. 
For each search algorithm, we output the order in which rooms where visited and indicate the shortest solution path from starting to finishing room. 
