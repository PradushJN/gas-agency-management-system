package gasbooking;
public class Book extends Delivery {
	
	public void BookGas() {
		Customer_Input();
		GasConnection_Input();
		Booking_Input();
		booking();
		Booking_Details();
		if(status==Status.B||status==Status.P) {
		Delivery_Input();
		delivery();
		GenerateInvoice();
		}
	}
	
}
