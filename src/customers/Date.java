package customers;

import java.util.Scanner;

public class Date {
	public int Day;
	public int Month;
	public int Year;
	Date(){}
	Date(int Date,int Month,int Year){this.Day=Day;this.Month=Month;this.Year=Year;}
	public void date() {
		Scanner in=new Scanner(System.in);
		Day=in.nextInt();
		Month=in.nextInt();
		Year=in.nextInt();
	}
	public void DisplayDate() {
		System.out.print(Day+"-"+Month+"-"+Year);
	}
}
