import java.io.*;
import java.util.*;

/*
ID: your_id_here
LANG: JAVA
TASK: gymnastics
*/

class gymnastics
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
//		Scanner sc = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(f.readLine());
//		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int numSessions = Integer.parseInt(st.nextToken());
		int numCows = Integer.parseInt(st.nextToken());
		
		int[][] scores = new int[numSessions][numCows];
		for (int i = 0; i < numSessions; i++)
		{
			st = new StringTokenizer(f.readLine());
//			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < numCows; j++)
			{
				scores[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int numConsistent = 0;
		for (int i = 1; i <= numCows; i++)
		{
			for (int j = i + 1; j <= numCows; j++)
			{
				boolean consistent = true;
				boolean iBeforeJ = aBeforeB(i, j, scores[0]);
				
				for (int k = 0; k < numSessions; k++)
				{
					boolean test = aBeforeB(i, j, scores[k]);
					if (iBeforeJ != test)
					{
						consistent = false;
						break;
					}
				}
				
				if (consistent == true)
					numConsistent++;
				
			}
		}
		
		out.println(numConsistent);
		out.close();
//		System.out.println(numConsistent);
	}
	
	static boolean aBeforeB (int a, int b, int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			if (array[i] == a)
				return true;
			if (array[i] == b)
				return false;
		}
		return false;
	}
}