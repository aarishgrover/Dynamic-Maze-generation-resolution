package maze;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class maze {
	private static Random myRandGen;
	static double myrandom() {
		return myRandGen.nextDouble(); //random in 0-1
		}
	public static node adjMat[][]; // adjacency matrix
	public maze(int i) // constructor
	{
	adjMat = new node[i][i];
	myRandGen=new java.util.Random(0); //seed is 0
	}
	
	public class node
	{
		int j;
		public node north;
		public node south;
		public node east;
		public node west;
		public boolean wasVisited;
		//public node n[];
		int xloc;
		int yloc;
		ArrayList<node> joined = new ArrayList<node>();
		public node(int x, int y, int z) // constructor
		{
		
		this.north = this.south = this.east = this.west =null;
		xloc = x;
		yloc = y;
		j=z;
		}
		} 
	public static void print(maze m)
	{
		for(int i=0;i<m.adjMat.length;i++)
		{
			
			for (int j=0; j<m.adjMat.length; j++)
			{
				System.out.print("+");
				
				if(m.adjMat[i][j].north == null)
				{
					if (j==0 && i==0)
					{
						System.out.print(" ");
					}
					else
					{
						System.out.print("-");
					}
					
				}
				else
				{
					System.out.print(" ");
				}
			}
			
			System.out.print("+\n");
			//System.out.print("|#");
			System.out.print("| ");

			for (int j=0; j<m.adjMat.length; j++)
			{
				
				if(m.adjMat[i][j].east == null)
				{
					System.out.print("| ");
				}
				else
				{
					//System.out.print(" #");
					System.out.print("  ");

				}
			}
			
			System.out.print("\n");
			
		}
		
		for (int j=0; j<m.adjMat.length; j++)
		{
			System.out.print("+");
			
			if(m.adjMat[m.adjMat.length-1][j].south == null && j!=m.adjMat.length-1)
			{
				System.out.print("-");
			}
			else
			{
				System.out.print(" ");
			}
		}
		
		System.out.print("+");
	}
	
	public static void printSol(maze m, ArrayList<Integer> Seq)
	{
		//System.out.println(Seq);
		for(int i=0;i<m.adjMat.length;i++)
		{
			
			for (int j=0; j<m.adjMat.length; j++)
			{
				System.out.print("+");
				
				if(m.adjMat[i][j].north == null)
				{
					if (j==0 && i==0)
					{
						System.out.print(" ");
					}
					else
					{
						System.out.print("-");
					}
					
				}
				else
				{
					System.out.print(" ");
				}
			}
			
			System.out.print("+\n");
			//System.out.print("|#");
			

			for (int j=0; j<m.adjMat.length; j++)
			{
				
				if(m.adjMat[i][j].west == null)
				{
					if (Seq.indexOf(m.adjMat[i][j].j) !=-1)
					{
						System.out.print("|" + Seq.indexOf(m.adjMat[i][j].j)%10);
					}
					else
					{
						System.out.print("| ");
					}
				}
				else
				{
					if (Seq.indexOf(m.adjMat[i][j].j) !=-1)
					{
						System.out.print(" " + Seq.indexOf(m.adjMat[i][j].j)%10);
					}
					else
					{
						System.out.print("  ");
					}

				}
			}
			
			System.out.print("|\n");
			
		}
		
		for (int j=0; j<m.adjMat.length; j++)
		{
			System.out.print("+");
			
			if(m.adjMat[m.adjMat.length-1][j].south == null && j!=m.adjMat.length-1)
			{
				System.out.print("-");
			}
			else
			{
				System.out.print(" ");
			}
		}
		
		System.out.print("+\n");
	}
	
	public static void printHash(maze m, ArrayList<Integer> Seq)
	{
		
		for(int i=0;i<m.adjMat.length;i++)
		{
			
			for (int j=0; j<m.adjMat.length; j++)
			{
				System.out.print("+");
				
				if(m.adjMat[i][j].north == null)
				{
					if (j==0 && i==0)
					{
						System.out.print(" ");
					}
					else
					{
						System.out.print("-");
					}
					
				}
				else
				{
						if (Seq.indexOf(m.adjMat[i][j].j) !=-1 && Seq.indexOf(m.adjMat[i][j].north.j) !=-1)
						{
							System.out.print("#");
						}
						else
						{
							System.out.print(" ");
						}
					
				}
			}
			
			System.out.print("+\n");
			//System.out.print("|#");
			

			for (int j=0; j<m.adjMat.length; j++)
			{
				
				if(m.adjMat[i][j].west == null)
				{
					if (Seq.indexOf(m.adjMat[i][j].j) !=-1)
					{
						System.out.print("|#");
					}
					else
					{
						System.out.print("| ");
					}
				}
				else
				{
					if (Seq.indexOf(m.adjMat[i][j].j) !=-1)
					{
						if (Seq.indexOf(m.adjMat[i][j].west.j) !=-1)
						{
							System.out.print("##");
						}
						else
						{
							System.out.print(" #");
						}
					}
					else
					{
						System.out.print("  ");
					}

				}
			}
			
			System.out.print("|\n");
			
		}
		
		for (int j=0; j<m.adjMat.length; j++)
		{
			System.out.print("+");
			
			if(m.adjMat[m.adjMat.length-1][j].south == null && j!=m.adjMat.length-1)
			{
				System.out.print("-");
			}
			else
			{
				System.out.print(" ");
			}
		}
		
		System.out.print("+");
	}
	
	public static ArrayList<Integer> DFS(maze m)
	{
		//stack data structure
		ArrayList<Integer> Seq = new ArrayList<Integer>();
		Stack<node> s = new Stack<node>();
		node current = m.adjMat[0][0];
		s.push(current);
		current.wasVisited = true;
		Seq.add(current.j);
		
		while(!s.isEmpty())
		{
			node temp = s.peek();
		//	System.out.println("\n"+temp.j);
			if(temp.equals(m.adjMat[m.adjMat.length-1][m.adjMat[0].length-1])) //Goal
			{
				//System.out.println("Solved");
				return Seq;
			}
				else if((temp.north == null || temp.north.wasVisited == true) && 
					(temp.west == null || temp.west.wasVisited == true) &&
					(temp.south == null || temp.south.wasVisited == true) &&
					(temp.east == null || temp.east.wasVisited == true))
				s.pop();
				else
			{	//System.out.println("\n");
				if(temp.south != null && temp.south.wasVisited == false)
					{
						temp.south.wasVisited = true;
						Seq.add(temp.south.j);
						//System.out.println(temp.south.j);
						s.push(temp.south);
					}
				else if(temp.east != null && temp.east.wasVisited == false)
				{
					temp.east.wasVisited = true;
					Seq.add(temp.east.j);
					//System.out.println(temp.east.j);
					s.push(temp.east);
				}
				else if(temp.north != null && temp.north.wasVisited == false)
				{
					temp.north.wasVisited = true;
					Seq.add(temp.north.j);
				//	System.out.println(temp.north.j);
					s.push(temp.north);
				}
				else if(temp.west != null && temp.west.wasVisited == false)
				{
					temp.west.wasVisited = true;
					Seq.add(temp.west.j);
				//	System.out.println(temp.west.j);
					s.push(temp.west);
				}
			}
		}
		
		return Seq;
	}
	public static ArrayList<Integer> BFS(maze m)
	{
		// Queue data structure
		ArrayList<Integer> Seq4 = new ArrayList<Integer>();
		Queue<node> queue = new LinkedList<node>();
		node current = adjMat[0][0];
		queue.add(current);
	//	System.out.println("\n"+current.j);
		current.wasVisited = true;
		Seq4.add(current.j);
		
		while(!queue.isEmpty())
		{
			node temp = queue.element();
			//System.out.println("\n"+temp.j);
			if(temp.equals(m.adjMat[m.adjMat.length-1][m.adjMat[0].length-1])) //Goal
			{
				//System.out.println("Solved");
				return Seq4;
			}
			else if((temp.north == null || temp.north.wasVisited == true) && 
					(temp.west == null || temp.west.wasVisited == true) &&
					(temp.south == null || temp.south.wasVisited == true) &&
					(temp.east == null || temp.east.wasVisited == true))
				queue.remove();
			else
			{
				if(temp.east != null && temp.east.wasVisited == false)
				{
					temp.east.wasVisited = true;
					Seq4.add(temp.east.j);
				//	System.out.println(temp.east.j);
					queue.add(temp.east);
					if (temp.east.j == (m.adjMat.length*m.adjMat.length)-1)
					{
						return Seq4;
					}
				}
				else if(temp.west != null && temp.west.wasVisited == false)
				{
					temp.west.wasVisited = true;
					Seq4.add(temp.west.j);
				//	System.out.println(temp.west.j);
					queue.add(temp.west);
					if (temp.west.j == (m.adjMat.length*m.adjMat.length)-1)
					{
						return Seq4;
					}
				}
				else if(temp.south != null && temp.south.wasVisited == false)
				{
					temp.south.wasVisited = true;
					Seq4.add(temp.south.j);
				//	System.out.println(temp.south.j);
					queue.add(temp.south);
					if (temp.south.j == (m.adjMat.length*m.adjMat.length)-1)
					{
						return Seq4;
					}
				}
				else if(temp.north != null && temp.north.wasVisited == false)
				{
					temp.north.wasVisited = true;
					Seq4.add(temp.north.j);
				//	System.out.println(temp.north.j);				
					queue.add(temp.north);
					if (temp.north.j == (m.adjMat.length*m.adjMat.length)-1)
					{
						return Seq4;
					}
				}	
			}
			
		}
		
		return Seq4;
	}
	public static void main(String[] args) {
		System.out.println("Enter Row and Column value");
		Scanner scan  = new Scanner(System.in);	
		int rowcolsize = scan.nextInt(); 
		maze m = new maze(rowcolsize);
		int d =-1;
		for(int i=0;i<m.adjMat.length;i++)
			for(int j=0;j<m.adjMat.length;j++)
				m.adjMat[i][j] = m.new node(i,j,++d);
		Stack<node> s =new Stack<node>();
		int nodesvisited = 1;
		int nodetotal = m.adjMat.length*m.adjMat.length;
		int x = 0;
		int y = 0;
		node current = m.adjMat[x][y];
		ArrayList<node> neighborcelllist = new ArrayList<node>();
		List<Integer> list = new ArrayList<>();

		while(nodetotal>nodesvisited)
		{	
			neighborcelllist.clear();
			x = current.xloc;
			y=current.yloc;
			//check x+1
			if(x+1<=m.adjMat.length-1)
			{
			if(m.adjMat[x+1][y].north==null && m.adjMat[x+1][y].south==null && m.adjMat[x+1][y].east==null&&m.adjMat[x+1][y].west==null)
			{
				neighborcelllist.add(m.adjMat[x+1][y]);
			}
			}
			//check y+1
			if(y+1<=m.adjMat.length-1)
			{
			if(m.adjMat[x][y+1].north==null&&m.adjMat[x][y+1].south==null&&m.adjMat[x][y+1].east==null&&m.adjMat[x][y+1].west==null)
			{
				neighborcelllist.add(m.adjMat[x][y+1]);
			}
			}
			//check x-1
			if(x-1>=0)
			{
				//System.out.println(x);
				if(m.adjMat[x-1][y].north==null&&m.adjMat[x-1][y].south==null&&m.adjMat[x-1][y].east==null&&m.adjMat[x-1][y].west==null)
				{
					neighborcelllist.add(m.adjMat[x-1][y]);
				}
			}
			//check y-1
			if(y-1>=0)
			{
				if(m.adjMat[x][y-1].north==null&&m.adjMat[x][y-1].south==null&&m.adjMat[x][y-1].east==null&&m.adjMat[x][y-1].west==null)
				{
					neighborcelllist.add(m.adjMat[x][y-1]);
				}
			}
			if(!neighborcelllist.isEmpty())
			{
				Random rand = new Random();
				int z = rand.nextInt(neighborcelllist.size());
				//System.out.println("currentnode "+current.j);
				//int z  =(int)(myrandom() * neighborcelllist.size());
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
		System.out.println("\n Maze");
		print(m);
		System.out.println("\n DFS");
		ArrayList<Integer> Seq = new ArrayList<Integer>();
		Seq = DFS(m);
		printSol(m,Seq);
		System.out.println("\n DFS HASH");
		printHash(m,Seq);
		
		for(int i=0; i< m.adjMat.length;i++)
			for(int j=0; j< m.adjMat.length;j++)
				m.adjMat[i][j].wasVisited=false;
		System.out.println("\n BFS");
		ArrayList<Integer> Seq1 = new ArrayList<Integer>();
		Seq1 = BFS(n);
		printSol(n, Seq1);
		System.out.println("\n BFS Hash");
		printHash(n,Seq);
		//final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
	    //PrintStream newConsole = System.out;
		//System.setOut(new PrintStream(myOut));
		//printSol(m, Seq);
		//final String standardOutput = myOut.toString();
	    //System.setOut(newConsole);
		//System.out.println(standardOutput);
	}

}
