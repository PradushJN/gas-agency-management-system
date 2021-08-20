package customers;

import java.util.Scanner;
import gassuplier.GasAgency;
public class Customer implements GasAgency {
	private String Name;
	private String MobileNumber;
	private Address address= new Address();
	
	public void Customer_Input() {
		Scanner in= new Scanner(System.in);
		//System.out.println("Enter Customer Details");
		System.out.print("\nCustomer Name: ");
		Name=in.nextLine();
		System.out.print("\nMobile number: ");
		MobileNumber=in.nextLine();
		address.address();
	}
	
	public String CustomerName() {
		return Name;
	}
	public String CustomerMobileNumber() {
		return MobileNumber;
	}
	public Address CustomerAdress() {
		return address;
	}
	public void Customer_Details() {
		System.out.println("Customer Name: "+Name);
		System.out.println("Mobile number: "+MobileNumber);
		address.DisplayAdress();
	}
	public void Display() {}
}
