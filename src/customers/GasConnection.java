package customers;

import java.util.Scanner;
import java.math.*;
public class GasConnection extends Customer {
	static protected int ConnectionNumber=(int)(Math.random()*10000)+1;
	private int NumberOfCylinders;
	private Date LastDateOfBooking=new Date();
	
	public void GasConnection_Input() {
		Scanner in= new Scanner(System.in);
		//System.out.println("Enter Gas Connection Details");
		//System.out.print("\nConnection Number: ");
		//ConnectionNumber=in.nextInt();
		System.out.print("\nNumber of cylinders: ");
		NumberOfCylinders=in.nextInt();
		System.out.print("\nLaste date of booking (DD MM YYYY): ");
		LastDateOfBooking.date();
	}
	
	public Date GetLastBookingDate() {
		return LastDateOfBooking;
	}
	
	public int NumberOfCylinder() {
		return NumberOfCylinders;
	}
	public int GetGasConnectionNumber() {
		return ConnectionNumber;
	}
	public void ChangeLastDateOfBooking(int day,int month,int year) {
		LastDateOfBooking.Day=day;
		LastDateOfBooking.Month=month;
		LastDateOfBooking.Year=year;
	}
	public void GasConnection_Details() {
		System.out.println("Gas Connecton Number: "+ConnectionNumber);
		System.out.println("Number of cylinders: "+NumberOfCylinders);
		System.out.print("Last Date Of Booking: ");
		LastDateOfBooking.DisplayDate();
		System.out.println();
	}
}
