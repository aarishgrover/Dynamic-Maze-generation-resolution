package maze;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import maze.maze.node;

public class mazetest {

	@Test
	public void dfstest() {
/*String bfs= 
"+ +-+-+-+\n"+
"|0 1|8 6|\n"+
"+-+ +-+ +\n"+
"|2|2 3 4|\n"+
"+ +-+-+ +\n"+
"|0 9 7 5|\n"+
"+ +-+-+-+\n"+
"|1 3 4 5|\n"+
"+-+-+-+ +";*/
String dfs =
"+ +-+-+-+\n"+
"|0 1|   |\n"+
"+-+ +-+ +\n"+
"| |2 3 4|\n"+
"+ +-+-+ +\n"+
"|8 7 6 5|\n"+
"+ +-+-+-+\n"+
"|9 0 1 2|\n"+
"+-+-+-+ +\n";
System.out.println(dfs);
maze m = new maze(4);
int d =-1;
for(int i=0;i<maze.adjMat.length;i++)
	for(int j=0;j<maze.adjMat.length;j++)
		maze.adjMat[i][j] = m.new node(i,j,++d);
Stack<node> s =new Stack<node>();
int nodesvisited = 1;
int nodetotal = maze.adjMat.length*maze.adjMat.length;
int x = 0;
int y = 0;
node current = maze.adjMat[x][y];
ArrayList<node> neighborcelllist = new ArrayList<node>();
List<Integer> list = new ArrayList<>();

while(nodetotal>nodesvisited)
{	
	neighborcelllist.clear();
	x = current.xloc;
	y=current.yloc;
	//check x+1
	if(x+1<=maze.adjMat.length-1)
	{
	if(maze.adjMat[x+1][y].north==null && maze.adjMat[x+1][y].south==null && maze.adjMat[x+1][y].east==null&&maze.adjMat[x+1][y].west==null)
	{
		neighborcelllist.add(maze.adjMat[x+1][y]);
	}
	}
	//check y+1
	if(y+1<=maze.adjMat.length-1)
	{
	if(maze.adjMat[x][y+1].north==null&&maze.adjMat[x][y+1].south==null&&maze.adjMat[x][y+1].east==null&&maze.adjMat[x][y+1].west==null)
	{
		neighborcelllist.add(maze.adjMat[x][y+1]);
	}
	}
	//check x-1
	if(x-1>=0)
	{
		//System.out.println(x);
		if(maze.adjMat[x-1][y].north==null&&maze.adjMat[x-1][y].south==null&&maze.adjMat[x-1][y].east==null&&maze.adjMat[x-1][y].west==null)
		{
			neighborcelllist.add(maze.adjMat[x-1][y]);
		}
	}
	//check y-1
	if(y-1>=0)
	{
		if(maze.adjMat[x][y-1].north==null&&maze.adjMat[x][y-1].south==null&&maze.adjMat[x][y-1].east==null&&maze.adjMat[x][y-1].west==null)
		{
			neighborcelllist.add(maze.adjMat[x][y-1]);
		}
	}
	if(!neighborcelllist.isEmpty())
	{
		//Random rand = new Random();
		//int z = rand.nextInt(neighborcelllist.size());
		//System.out.println("currentnode "+current.j);
		int z  =(int)(maze.myrandom() * neighborcelllist.size());
		for(int i =0; i<neighborcelllist.size();i++)
		{
			//System.out.println("neighbor list index "+i+" value "+neighborcelllist.get(i).j);
		}
		//System.out.println("chosen index "+z);
		node chosenneighbor = neighborcelllist.get(z);
		int xresult = chosenneighbor.xloc-x;
		int yresult = chosenneighbor.yloc-y;
		if(xresult==1)
		{
			chosenneighbor.north = current;
			current.south = chosenneighbor;
			s.push(current);
			current = chosenneighbor;
			nodesvisited++;
		}
		else if(xresult==-1)
		{
			chosenneighbor.south = current;
			current.north = chosenneighbor;
			s.push(current);
			current = chosenneighbor;
			nodesvisited++;
		}
		else if(yresult==1)
		{
			chosenneighbor.west = current;
			current.east = chosenneighbor;
			s.push(current);
			current = chosenneighbor;
			nodesvisited++;
		}
		else if(yresult==-1)
		{
			chosenneighbor.east = current;
			current.west = chosenneighbor;
			s.push(current);
			current = chosenneighbor;
			nodesvisited++;
		}
		list.add(chosenneighbor.j);
		//s.push(current);
		//current = chosenneighbor;
		//nodesvisited++;
	}
	else
	{
		current = s.pop();
	}		
}
//Collections.sort(list);
//System.out.println(list);
ArrayList<Integer> Seq = new ArrayList<Integer>();
Seq = maze.DFS(m);
//console out
ByteArrayOutputStream baos = new ByteArrayOutputStream();
PrintStream ps = new PrintStream(baos);
PrintStream old = System.out;
System.setOut(ps);
maze.printSol(m, Seq);
System.out.flush();
System.setOut(old);
//System.out.println(baos.toString());

assertEquals(dfs, baos.toString());
//System.out.println(standardOutput);
//System.out.println(standardOutput);
//maze.printSol(m,Seq);
///System.out.println("\n DFS HASH");
//maze.printHash(m,Seq);
//System.out.println("\n BFS");
//ArrayList<Integer> Seq1 = new ArrayList<Integer>();
//Seq1 = maze.BFS(m);
//maze.printSol(m, Seq1);
//System.out.println("\n BFS Hash");
//maze.printHash(m,Seq1);
//final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
//PrintStream newConsole = System.out;
//System.setOut(new PrintStream(myOut));
//printSol(m, Seq);
//final String standardOutput = myOut.toString();
//System.setOut(newConsole);
//System.out.println(standardOutput);


//final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
//PrintStream newConsole = System.out;
//System.setOut(new PrintStream(myOut));
//printSol(m, Seq);
//final String standardOutput = myOut.toString();
//System.setOut(newConsole);
//System.out.println(standardOutput);
		//assertEquals(str, str);
            
    }


@Test
public void bfstest()
{
	String bfs= 
	"+ +-+-+-+\n"+
	"|0 1|8 6|\n"+
	"+-+ +-+ +\n"+
	"|2|2 3 4|\n"+
	"+ +-+-+ +\n"+
	"|0 9 7 5|\n"+
	"+ +-+-+-+\n"+
	"|1 3 4 5|\n"+
	"+-+-+-+ +\n";
	
	maze m = new maze(4);
	int d =-1;
	for(int i=0;i<maze.adjMat.length;i++)
		for(int j=0;j<maze.adjMat.length;j++)
			maze.adjMat[i][j] = m.new node(i,j,++d);
	Stack<node> s =new Stack<node>();
	int nodesvisited = 1;
	int nodetotal = maze.adjMat.length*maze.adjMat.length;
	int x = 0;
	int y = 0;
	node current = maze.adjMat[x][y];
	ArrayList<node> neighborcelllist = new ArrayList<node>();
	List<Integer> list = new ArrayList<>();

	while(nodetotal>nodesvisited)
	{	
		neighborcelllist.clear();
		x = current.xloc;
		y=current.yloc;
		//check x+1
		if(x+1<=maze.adjMat.length-1)
		{
		if(maze.adjMat[x+1][y].north==null && maze.adjMat[x+1][y].south==null && maze.adjMat[x+1][y].east==null&&maze.adjMat[x+1][y].west==null)
		{
			neighborcelllist.add(maze.adjMat[x+1][y]);
		}
		}
		//check y+1
		if(y+1<=maze.adjMat.length-1)
		{
		if(maze.adjMat[x][y+1].north==null&&maze.adjMat[x][y+1].south==null&&maze.adjMat[x][y+1].east==null&&maze.adjMat[x][y+1].west==null)
		{
			neighborcelllist.add(maze.adjMat[x][y+1]);
		}
		}
		//check x-1
		if(x-1>=0)
		{
			//System.out.println(x);
			if(maze.adjMat[x-1][y].north==null&&maze.adjMat[x-1][y].south==null&&maze.adjMat[x-1][y].east==null&&maze.adjMat[x-1][y].west==null)
			{
				neighborcelllist.add(maze.adjMat[x-1][y]);
			}
		}
		//check y-1
		if(y-1>=0)
		{
			if(maze.adjMat[x][y-1].north==null&&maze.adjMat[x][y-1].south==null&&maze.adjMat[x][y-1].east==null&&maze.adjMat[x][y-1].west==null)
			{
				neighborcelllist.add(maze.adjMat[x][y-1]);
			}
		}
		if(!neighborcelllist.isEmpty())
		{
			//Random rand = new Random();
			//int z = rand.nextInt(neighborcelllist.size());
			//System.out.println("currentnode "+current.j);
			int z  =(int)(maze.myrandom() * neighborcelllist.size());
			for(int i =0; i<neighborcelllist.size();i++)
			{
				//System.out.println("neighbor list index "+i+" value "+neighborcelllist.get(i).j);
			}
			//System.out.println("chosen index "+z);
			node chosenneighbor = neighborcelllist.get(z);
			int xresult = chosenneighbor.xloc-x;
			int yresult = chosenneighbor.yloc-y;
			if(xresult==1)
			{
				chosenneighbor.north = current;
				current.south = chosenneighbor;
				s.push(current);
				current = chosenneighbor;
				nodesvisited++;
			}
			else if(xresult==-1)
			{
				chosenneighbor.south = current;
				current.north = chosenneighbor;
				s.push(current);
				current = chosenneighbor;
				nodesvisited++;
			}
			else if(yresult==1)
			{
				chosenneighbor.west = current;
				current.east = chosenneighbor;
				s.push(current);
				current = chosenneighbor;
				nodesvisited++;
			}
			else if(yresult==-1)
			{
				chosenneighbor.east = current;
				current.west = chosenneighbor;
				s.push(current);
				current = chosenneighbor;
				nodesvisited++;
			}
			list.add(chosenneighbor.j);
			//s.push(current);
			//current = chosenneighbor;
			//nodesvisited++;
		}
		else
		{
			current = s.pop();
		}		
	}
	//Collections.sort(list);
	//System.out.println(list);
	maze n = m;
	//System.out.println("\n Maze");
	//maze.print(m);
	//System.out.println("\n DFS");
	ArrayList<Integer> Seq = new ArrayList<Integer>();
	//Seq = maze.DFS(m);
	//maze.printSol(m,Seq);
	//System.out.println("\n DFS HASH");
	//maze.printHash(m,Seq);
	
	for(int i=0; i< maze.adjMat.length;i++)
		for(int j=0; j< maze.adjMat.length;j++)
			maze.adjMat[i][j].wasVisited=false;
	//System.out.println("\n BFS");
	ArrayList<Integer> Seq1 = new ArrayList<Integer>();
	Seq1 = maze.BFS(n);
	//console out
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	PrintStream old = System.out;
	System.setOut(ps);
	maze.printSol(n, Seq1);
	System.out.flush();
	System.setOut(old);
	//System.out.println(baos.toString());
	assertEquals(bfs, baos.toString());
	//System.out.println("\n BFS Hash");
	//maze.printHash(n,Seq);
}
}