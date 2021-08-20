package customers;
import java.util.*;
import java.io.*;
public class Address {
    public  String Street;
	public  String Area;
	public  long PinCode;
	
	public Address(){}
	public void address() {
		Scanner in= new Scanner(System.in);
		System.out.print("\nAddress\n");
		System.out.print("\nStreet: ");
		Street=in.nextLine();
		System.out.print("\nArea: ");
		Area=in.nextLine();
		System.out.print("\nPincode: ");
		PinCode=in.nextLong();
	}
	
	public void DisplayAdress() {
		System.out.println("Street"+Street);
		System.out.println("Area"+Area);
		System.out.println("Pincode"+PinCode);
	}
}
