import java.io.*;
import java.util.*;

/*
ID: your_id_here
LANG: JAVA
TASK: lineup
*/

class lineup
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("lineup.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
//		Scanner sc = new Scanner(System.in);
		
		String[] cows = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
		
		int numCond = Integer.parseInt(f.readLine());
//		int numCond = Integer.parseInt(sc.nextLine());
		
		String[] conditions = new String[numCond];
		for (int i = 0; i < numCond; i++)
		{
			conditions[i] = f.readLine();
//			conditions[i] = sc.nextLine();
		}
		
		String[][] translConds = new String[numCond][2];
		
		for (int i = 0; i < numCond; i++)
		{
			String[] twoCows = conditions[i].split(" must be milked beside ");
			int[] twoCowIndices = new int[2];
			twoCowIndices[0] = Arrays.asList(cows).indexOf(twoCows[0]);
			twoCowIndices[1] = Arrays.asList(cows).indexOf(twoCows[1]);
			
			translConds[i][0] = "" + twoCowIndices[0] + twoCowIndices[1];
			translConds[i][1] = "" + twoCowIndices[1] + twoCowIndices[0];
		}
		
		
		
		iterate("01234567", "", translConds);
		/*for (int i = 0; i < iterations.size(); i++)
		{
			System.out.println(iterations.get(i));
		}*/
		
//		printAns(iterations.get(0), cows);
		printAns(iterations.get(0), cows, out);
		out.close();
	}
	
	static ArrayList<String> iterations = new ArrayList<String>();
	static void iterate(String str, String stringSoFar, String[][]conditions)
	{
		if (str.length() == 0)
		{
			//System.out.println("This is an iteration: '" + stringSoFar + "'");
			if (stringMeetsRequirements(stringSoFar, conditions))
			{
				iterations.add(stringSoFar);
			}
			return;
		}
		
		for (int i = 0; i < str.length(); i++)
		{
			String splitter = str.substring(i, i + 1);
			stringSoFar += splitter;
			String[] newstringPieces = str.split(splitter);
			String newstring = "";
			for (int j = 0; j < newstringPieces.length; j++)
			{
				newstring += newstringPieces[j];
			}
			iterate(newstring, stringSoFar, conditions);
			stringSoFar = stringSoFar.substring(0, stringSoFar.length() - 1);
		}
	}
	
	static boolean stringMeetsRequirements(String string, String[][] conditions)
	{
		for (int i = 0; i < conditions.length; i++)
		{
			if (!(string.contains(conditions[i][0]) || string.contains(conditions[i][1])))
				return false;
		}
		return true;
	}
	
	static void printAns(String indexOrder, String[] array)
	{
		for (int i = 0; i < indexOrder.length(); i++)
		{
			int index = Integer.parseInt(indexOrder.substring(i, i + 1));
//			out.println(array[index]);
			System.out.println(array[index]);
		}
	}
	static void printAns(String indexOrder, String[] array, PrintWriter out)
	{
		for (int i = 0; i < indexOrder.length(); i++)
		{
			int index = Integer.parseInt(indexOrder.substring(i, i + 1));
			out.println(array[index]);
//			System.out.println(array[index]);
		}
	}
}