package ASM;

import java.util.Scanner;

public class Messege {
	char Q[];
	int MAX = 250;
	int f, r;
	
	Messege(int M)
	{
		MAX = M;
		Q = new char[MAX];
		f = -1;
		r = 0;
	}
	int Numcount() 
	{
		if(f == r)
			return 0;
		else
			return ((MAX - f) + r) % MAX;
	}
	void enqueue(char x)
	{
		if(Numcount() == MAX -1)
			System.out.print("Queue is full.");
		else
		{
			Q[r] = x;
			r = (r+1) % MAX;
			if(f==-1)
				f=0;
		}
	}
	
	char dequeue()
	{
		char x = ' ';
		if(Numcount()==0)
			System.out.print("Queue is empty.");
		else
		{
			x = Q[f];
			f = (f+1) % MAX;
		}
		return x;
	}
	
	String Transfer(String s1)
	{
		String s2;
		int i = 0;
		int count =0;
		s2="";
		if(s1.length() ==0)
		{
			System.out.println("Chuoi rong. Vui long nhap lai");
			return "";
		}
		else if(s1.length()>255)
		{
			System.out.println("Chuoi qua 255 ky tu. Vui long nhap lai");
			return "";
			}
		else {
				try {		
					while(i < s1.length())	
					{
						while(Numcount() < MAX-1)
						{
							char c = s1.charAt(i);
							enqueue(c);
							i = i+1;
							if(i >= s1.length())
								break;
						}
						while(Numcount() > 0)
						{
							char c = dequeue();
							s2 = s2 +c;						}
						count = count +1;
					}
					
					while(Numcount() > 0)
					{
						char c = dequeue();
						s2 = s2 +c;
					}
					System.out.print("\n So lan su dung Buffer Q: "+count);
					return s2;
				}
				catch(Exception e)
				{
					System.out.println("Co loi xay ra"+ e.toString());
					return "";
				}
		}
		
	}
	public static void main(String[] args) {
		Messege Q = new Messege(10);
		String s1 = "";
		System.out.println("Nhap chuoi can chuyen: s = ");
		Scanner sc = new Scanner(System.in);
		s1 = sc.nextLine();
		long begin, end, time;
		begin = System.currentTimeMillis();
		String s = Q.Transfer(s1);
		System.out.print("\n S2: \n" + s);
		end = System.currentTimeMillis();
		time = end - begin;
		System.out.print("\nExecuted Time of 10MB Queue: ");
		System.out.print(time + " miliseconds.");
	}
}
