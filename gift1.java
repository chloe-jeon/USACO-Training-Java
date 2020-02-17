import java.io.*;
import java.util.*;

/*
ID: your_id_here
LANG: JAVA
TASK: gift1
*/

class gift1 {
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
//		Scanner sc = new Scanner(System.in);
		
//		out.println("Hello World");
		
		//StringTokenizer st = new StringTokenizer(f.readLine());
		//int numppl = Integer.parseInt(st.nextToken());
		int numppl = Integer.parseInt(f.readLine());
//		int numppl = Integer.parseInt(sc.nextLine());
		
		String pplNames[] = new String[numppl];
		int balance[] = new int[numppl];
		for (int i = 0; i < numppl; i++)
		{
			pplNames[i] = f.readLine();
//			pplNames[i] = sc.nextLine();
			balance[i] = 0;
		}
		
		for (int i = 0; i < numppl; i++)
		{
			String name = f.readLine();
//			String name = sc.nextLine();
			int nameIndex = findIndexOf(name, pplNames);
			String[] giftString = f.readLine().split(" ");
//			String[] giftString = sc.nextLine().split(" ");
			int money = Integer.parseInt(giftString[0]);
			int divide = Integer.parseInt(giftString[1]);
			balance[nameIndex] -= money;
			int gift = 0;
			if (divide != 0)
			{
				gift = money / divide;
				money = money % divide;
			}
			else
			{
				gift = 0;
			}
			balance[nameIndex] += money;
			for (int j = 0; j < divide; j++)
			{
				String giftReceiver = f.readLine();
//				String giftReceiver = sc.nextLine();
				int receiverIndex = findIndexOf(giftReceiver, pplNames);
				balance[receiverIndex] += gift;
			}
		}
		
		for (int i = 0; i < numppl; i++)
		{
			out.println(pplNames[i] + " " + balance[i]);
			System.out.println(pplNames[i] + " " + balance[i]);
		}
		out.close();
	}
	static int findIndexOf(String find, String[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			if (array[i].contentEquals(find))
				return i;
		}
		return -1;
	}
}