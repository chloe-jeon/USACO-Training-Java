import java.io.*;
import java.util.*;

/*
ID: your_id_here
LANG: JAVA
TASK: whereami
*/

class whereami
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
//		Scanner sc = new Scanner(System.in);
		
		f.readLine();
		String houses = f.readLine();
//		sc.nextLine();
//		String houses = sc.nextLine();
		
		out.println(minLength(houses));
		out.close();
//		System.out.println(minLength(houses));
		
	}
	
	static int minLength(String string)
	{
		for (int length = 1; length < string.length(); length++)
		{
			boolean noMatches = true;
			for (int index = 0; index < string.length() - length; index++)
			{
				String substring = string.substring(index, index + length);
				String checkString = string.substring(index + 1);
				if (checkString.contains(substring))
				{
					noMatches = false;
					break;
				}
			}
			if (noMatches == true)
				return length;
		}
		return string.length();
	}
}