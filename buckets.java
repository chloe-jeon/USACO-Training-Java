import java.io.*;
import java.util.*;

/*
ID: your_id_here
LANG: JAVA
TASK: buckets
*/

class buckets {
	public static void main (String [] args) throws IOException {
//		BufferedReader f = new BufferedReader(new FileReader("buckets.in"));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
		Scanner sc = new Scanner(System.in);
		
		String[] farm = new String[10];
		for (int i = 0; i < 10; i++)
		{
			farm[i] = sc.nextLine();
		}
		
		int[] lakePos = findLake(farm);
		System.out.print(findFarm(lakePos[0], lakePos[1], farm));
	}
	
	static int[] findLake(String[] farm)
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
				if (farm[i].charAt(j) == 'L')
				{
					int[] ans = {i, j};
					return ans;
				}
		}
		return null;
	}
	
	static int findFarm(int row, int col, String[] grid)
	{
		char[][] grid2 = new char[10][10];
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				grid2[i][j] = grid[i].charAt(j);
			}
		}
		int[][] grid3 = new int[10][10];
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				grid3[i][j] = -1;
			}
		}
		grid3[row][col] = 0;
		
		ArrayList<int[]> bfs = new ArrayList<int[]>();
		int lastValue = 0;
		while(true)
		{
			if(grid2[row][col] == 'B')
				return lastValue;
			
			
			
			int[] temp = new int[2];
			
			if (validPos(row + 1, col, grid2))
			{
				grid3[row + 1][col] = grid3[row][col] + 1;
				grid2[row + 1][col] = 'C';
				temp[0] = row + 1; temp[1] = col;
				bfs.add(temp);
			}
			
			if (validPos(row - 1, col, grid2))
			{
				grid3[row - 1][col] = grid3[row][col] + 1;
				grid2[row - 1][col] = 'C';
				temp[0] = row - 1; temp[1] = col;
				bfs.add(temp);
			}
			
			if (validPos(row, col + 1, grid2))
			{
				grid3[row][col + 1] = grid3[row][col] + 1;
				grid2[row][col + 1] = 'C';
				temp[0] = row; temp[1] = col + 1;
				bfs.add(temp);
			}
			
			if (validPos(row, col - 1, grid2))
			{
				grid3[row][col - 1] = grid3[row][col] + 1;
				grid2[row][col - 1] = 'C';
				temp[0] = row; temp[1] = col - 1;
				bfs.add(temp);
			}
			
			
			
			System.out.println(row + " " + col);
			System.out.println("grid2");
			for (int i = 0; i < 10; i++)
			{
				for (int j = 0; j < 10; j++)
				{
					System.out.print(grid2[i][j]);
				}
				System.out.println();
			}
			System.out.println("grid3");
			for (int i = 0; i < 10; i++)
			{
				for (int j = 0; j < 10; j++)
				{
					if (grid3[i][j] != -1)
						System.out.print(grid3[i][j]);
					else
						System.out.print(".");
				}
				System.out.println();
			}
			
			lastValue = grid3[row][col];
			
			int[] newPos = bfs.remove(0);
			row = newPos[0];
			col = newPos[1];
		}
	}
	
	static boolean validPos(int row, int col, char[][] map)
	{
		if (!(0 <= row && row < 10 && 0 <= col && col < 10))
			return false;
		if (map[row][col] != '.')
			return false;
		return true;
	}
}