import java.io.*;
import java.util.*;

/*
ID: your_id_here
LANG: JAVA
TASK: ride
*/

class ride {
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		//Scanner sc = new Scanner(System.in);
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		String cometName = st.nextToken();
		//String cometName = sc.nextLine();
		
		st = new StringTokenizer(f.readLine());
		String groupName = st.nextToken();
		//String groupName = sc.nextLine();
		
		int cometNum = 1;
		int groupNum = 1;
		
		for (int i = 0; i < cometName.length(); i++)
		{
			cometNum *= cometName.charAt(i) - 64;
		}
		for (int i = 0; i < groupName.length(); i++)
		{
			groupNum *= groupName.charAt(i) - 64;
		}
		cometNum = cometNum % 47;
		groupNum = groupNum % 47;
		
		if (cometNum == groupNum)
		{
			out.println("GO");
		}
		else
		{
			out.println("STAY");
		}
		
		out.close();
	}
}