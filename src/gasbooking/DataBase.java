package gasbooking;

import customers.*;
public class DataBase {
	private String CustomerName;
	private String CustomerMobileNumber;
	public  Address address= new Address();
	private int GasConnectionNumber;
	private int NumberOfCylinders;
	private Date LastDateOfBooking=new Date();
	private Date BookingDate=new Date();
	private double Amount;
	private double Refund;
	static public Status status;
	private Date DeliveryDate=new Date();
	private String DeliveryPersonName;
	private String DeliveryPhoneNumber;
	 
	 public void CylindersDeliveredLateInMonth(DataBase[] D,int Index) {
		 int LateDeliveredCylinders=0;
		 for(int j=0;j<=Index;++j) {
			 for(int i=0;i<=Index;++i) {
				 int NumberOfDays=(D[i].DeliveryDate.Day-D[i].BookingDate.Day)+
						 		   30*(D[i].DeliveryDate.Month-D[i].BookingDate.Month)+
					 		       365*(D[i].DeliveryDate.Year-D[i].BookingDate.Year);
				 if(D[i].BookingDate.Month==D[j].BookingDate.Month)
					 if(NumberOfDays>7) 
						 LateDeliveredCylinders++;
			 }
			 System.out.println("The number of Cylinder Delivered in Month "+D[j].BookingDate.Month+": "+LateDeliveredCylinders);
			 LateDeliveredCylinders=0;
		 }
	 }
	
	 public void NumberofCylinderDelivered(DataBase[] D,int Index) {
		 int NumberOfCylinders=0;
		 for(int i=0;i<=Index;++i) {
			 NumberOfCylinders+=D[i].NumberOfCylinders;
		 }
		 System.out.println("\nThe Total number of Cylinders Delivered: "+NumberOfCylinders);
	 }
	 
	 public void NumberofCylinderDeliveredInArea(DataBase[] D,int Index) {
		 int NumberOfCylinders=0;
		 for(int j=0;j<=Index;++j) {
			 for(int i=0;i<=Index;++i) {
				 if(D[i].address.Area==D[j].address.Area)
					 NumberOfCylinders+=D[i].NumberOfCylinders;
			 }
			 System.out.println("\nThe Total number of Cylinders Delivered In Area : "+NumberOfCylinders);
			 NumberOfCylinders=0;
		 }
	 }
	 
	 public void SingleCylinderCustomers(DataBase[] D,int Index) {
		 System.out.println("The Customers with Single cylinder subscriptions: ");
		 for(int i=0;i<=Index;++i) {
			 if(D[i].NumberOfCylinders==1) {
				 System.out.println("Customer Name: " +D[i].CustomerName);
				 System.out.println("Customer Phone Number"+D[i].CustomerMobileNumber);
				 System.out.println("Gas Connection Number: "+D[i].GasConnectionNumber);
			 }
			 System.out.println("\n");
		 }
			 
	 }
		 
	 public void Report(DataBase[] D,int Index) {
		 System.out.println("-------------------------------------------------REPORT---------------------------------------------------------------");
		 System.out.println("\n\nReport of all succesfully booked Orders: ");
		 for(int i=0;i<=Index;++i) {        
			 if(D[i].status==Status.B) {
				 D[i].Display();
			 }
		 }
		 System.out.println("\n\nReport of all Cancelled Orders: ");
		 for(int i=0;i<=Index;++i) {        
			 if(D[i].status==Status.C) {
				 D[i].Display();
			 }
		 }
		 System.out.println("\n\nReport of all Succesfully Delivered Orders: ");
		 for(int i=0;i<=Index;++i) {        
			 if(D[i].status==Status.D) {
				 D[i].Display();
			 }
		 }
		 System.out.println("\n\nReport of all Late delivered Orders: ");
		 for(int i=0;i<=Index;++i) {        
			 if(D[i].status==Status.P) {
				 D[i].Display();
			 }
		 }
			
			 
	 }
	 
	 public void Customer_DeliveryPerson(DataBase[] D,int Index) {
		 for(int j=0;j<=Index;++j) {
			 System.out.println("The Customers who recieved delivery from: "+D[j].DeliveryPersonName);
			 for(int i=0;i<=Index;++i) {
				 if(D[i].DeliveryPersonName==D[j].DeliveryPersonName) {
					 System.out.println("Customer Name: "+D[i].CustomerName);
					 System.out.println("Address: ");
					 D[i].address.DisplayAdress();
				 }
			 }
		 }
	 }
	
	public void Display() {
		System.out.println();
		System.out.println("Customer Name: "+CustomerName);
		System.out.println("Customer Phone Number: "+CustomerMobileNumber);
		System.out.println("Adress: ");
		address.DisplayAdress();
		System.out.println("Gas Connection Number: "+GasConnectionNumber);
		System.out.println("Booking Date: ");
		BookingDate.DisplayDate();
		System.out.println("Amount: "+Amount);
		System.out.println("Refund: "+Refund);
		System.out.println("Delivery Person: "+DeliveryPersonName);
		System.out.println("Delivery Person Phone Number: "+DeliveryPhoneNumber);
		System.out.println("Delivery Date: ");
		DeliveryDate.DisplayDate();	
	}
	
	DataBase(){}
	public DataBase(String CustomerName,String CustomerMobileNumber,Address address,int GasConnectionNumber,int NumberOfCylinders,Date BookingDate,double Amount,double Refund,Status status,Date DeliveryDate,String DeliveryPersonName,String DeliveryPhoneNumber){
		this.CustomerName=CustomerName;
		this.CustomerMobileNumber=CustomerMobileNumber;
		this.address.Street=address.Street;
		this.address.Area=address.Area;
		this.address.PinCode=address.PinCode;
		this.GasConnectionNumber=GasConnectionNumber;
		this.NumberOfCylinders=NumberOfCylinders;
		this.BookingDate.Day=BookingDate.Day;
		this.BookingDate.Month=BookingDate.Month;
		this.BookingDate.Year=BookingDate.Year;
		this.Amount=Amount;
		this.Refund=Refund;
		this.status=status;
		this.DeliveryDate.Day=DeliveryDate.Day;
		this.DeliveryDate.Month=DeliveryDate.Month;
		this.DeliveryDate.Year=DeliveryDate.Year;
		this.DeliveryPersonName=DeliveryPersonName;
		this.DeliveryPhoneNumber=DeliveryPhoneNumber;
	}
	
}
