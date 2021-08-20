package gasbooking;
import java.util.*;
import java.io.*;
import customers.GasConnection;
public class Delivery extends Booking {
	private Date DeliveryDate=new Date();
	private String PersonName;
	private int DeliveryOTP;
	private String PhoneNumber;
	Date CurrentDate=new Date();
	public boolean ValidateDelivery() {
		if(DeliveryOTP==GenerateOTP())
			return true;
		else {
			System.out.println("\nWRONG OTP, Cancellng the order");
			return false;
		}		
	}
	
	public Date GetDeliveryDate() {
		return DeliveryDate;
	}
	public String GetDeliveryPersonName() {
		return PersonName;
	}
	public String GetDeliveryPersonPhoneNumber() {
		return PhoneNumber;
	}
    public void delivery() {
    	int DiffInDate;
		DiffInDate=(DeliveryDate.Day-BookingDate.Day)+
					30*(DeliveryDate.Month-BookingDate.Month)+
					365*(DeliveryDate.Year-BookingDate.Year);
		
		if(DiffInDate<7)
			if(ValidateDelivery()==true) {
				Delivered();
			}
			else {
				Cancelled();
			}
		else {
			Pending();
			System.out.println("Your Order has been Delayed to some unanticipated circumstances");
			System.out.print("\nORDER STATUS: ");
			switch(status) {
			case B:System.out.print("BOOKED");break;
			case C:System.out.print("CANCELLED");break;
			case D:System.out.print("DELIVERED");break;
			case P:System.out.print("PENDING");break;
			}
			RefundDueToDelay();
			Delivered();
		}
    }
    
    public void Delivery_Input() {
    	Scanner in=new Scanner(System.in);
    	//System.out.println("\nEnter Delivery Details");
    	System.out.print("\n\nDelivery Person Name: ");
    	PersonName=in.nextLine();
    	System.out.print("\nDelivery Date (DD MM YYYY): " );
    	DeliveryDate.date();
    	System.out.print("\nPhone Number: ");
    	PhoneNumber=in.nextLine();
    	System.out.print("Verify OTP: ");
    	DeliveryOTP=in.nextInt();
    	CurrentDate.Day=GetLastBookingDate().Day;
    	CurrentDate.Month=GetLastBookingDate().Month;
    	CurrentDate.Year=GetLastBookingDate().Year;
    }
    
    public void GenerateInvoice() {
    	System.out.println("                                                          INVOICE                                                         ");
    	System.out.print("\nGas Agency code: "+AgencyCode);
    	System.out.print("\t\tDate of Invoice:");
    	CurrentDate.DisplayDate();
    	System.out.print("\nGas Agency Name: "+AgencyName);
    	System.out.print("\t\tGas Agency Phone Number: "+PhoneNumber);
    	System.out.print("\nGas Connection Number: "+GasConnectionNumber);
    	System.out.print("\t\tCustomer Name: "+CustomerName());
    	System.out.print("\nBooking date: ");
    	BookingDate.DisplayDate();
    	System.out.print("\t\t\tCustomer Mobile Number: "+CustomerMobileNumber());
    	System.out.println("\n---------------------------------------------------------------------------------------------------------------------\n");
    	System.out.println("Amount: "+GetAmount());
    	System.out.println("Refund: "+GetRefundAmount());
    	System.out.println("Total Amount: "+(GetAmount()-GetRefundAmount()));
    	System.out.println("\n---------------------------------------------------------------------------------------------------------------------\n");
    	System.out.print("\nDelivery Person Name: "+PersonName);
    	System.out.print("\t\tDelivery Person Phone Number: "+PhoneNumber);
    	System.out.print("\nDelivery Date: ");
    	DeliveryDate.DisplayDate();
    	System.out.print("\nStatus: ");
		switch(status) {
		case B:System.out.print("BOOKED");break;
		case C:System.out.print("CANCELLED");break;
		case D:System.out.print("DELIVERED");break;
		case P:System.out.print("PENDING");break;
		}
		System.out.println("\n---------------------------------------------------------------------------------------------------------------------\n");
    }
    
}
