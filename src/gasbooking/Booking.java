package gasbooking;

import customers.GasConnection;
public class Booking extends GasConnection{
	protected int GasConnectionNumber;
	protected Date BookingDate=new Date();
	private int OTP;
	private static double Amount;
	private static double Refund;
	static public Status status;
	
	private boolean ValidateBookingDate() {
		int DiffInDate;
		boolean Flag=true;
		DiffInDate=(BookingDate.Day-GetLastBookingDate().Day)+
					30*(BookingDate.Month-GetLastBookingDate().Month)+
					365*(BookingDate.Year-GetLastBookingDate().Year);
		System.out.println(DiffInDate);
		if(NumberOfCylinder()==1) {
			if(DiffInDate>=30)
				Flag=true;
			else
				Flag=false;
		}
		else if(NumberOfCylinder()==2) {
			if(DiffInDate>=50)
				Flag=true;
			else
				Flag=false;
		}
		return Flag;
	}
	
	public double GetAmount() {
		return 750*NumberOfCylinder();
	}
	public double GetRefundAmount() {
		return Refund;
	}
	public void Booking_Input() {
		GasConnectionNumber=ConnectionNumber;
		//System.out.println("Enter Booking Details");
		System.out.print("\nBooking Date (DD MM YYYY): ");
		BookingDate.date();
		OTP=GenerateOTP();
		Amount=GetAmount();
	}
	public Date GetBookingDate() {
		return BookingDate;
	}
	public void Booking_Details() {
		System.out.print("\nBooking Date: ");
		BookingDate.DisplayDate();
		System.out.print("\nAmount: "+Amount);
		System.out.print("\nStatus: ");
		switch(status) {
		case B:System.out.print("BOOKED");break;
		case C:System.out.print("CANCELLED");break;
		case D:System.out.print("DELIVERED");break;
		case P:System.out.print("PENDING");break;
		}
		if(status==Status.B)
			System.out.print("\n\nOTP(Don't Share with any body): "+OTP);
	}
	public int GenerateOTP() {
		return (int)(Math.random()*(100000));
	}
	public void Delivered() {
		status=Status.D;
	}
	public void Cancelled() {
		status=Status.C;
	}
	public void Booked() {
		ChangeLastDateOfBooking(BookingDate.Day,BookingDate.Month,BookingDate.Year);
		status=Status.B;
	}
	public void Pending() {
		status=Status.P;
	}
	protected void RefundDueToDelay() {
		System.out.println("\nSorry for the Delay");
		System.out.println("5% of your Total Amount will refunded");
		Refund=(0.05)*Amount;
	}
	public void booking(){
		boolean Flag;
		Flag=ValidateBookingDate();
		if(Flag==true) {
			Booked();
		}
		else {
			Cancelled();
			System.out.println("\nWe are sorry, Booking cannot be done because it is too early to accept your order");
		}
	}
}
