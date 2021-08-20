package gasbooking;

import java.util.*;
import java.io.*;
public class Menu extends DataBase{
	 public static DataBase D[]=new DataBase[50];
	 DataBase Temp=new DataBase();
	 private int Index=0;
	 
	 public void UpdateIndex() {
		 Index++;
	 }
	/* public void UpdateDatabase(){
		 D[Index]=new DataBase(CustomerName(),CustomerMobileNumber(),CustomerAdress(),GetGasConnectionNumber(),NumberOfCylinder(),GetBookingDate(),GetAmount(),GetRefundAmount(),status,GetDeliveryDate(),GetDeliveryPersonName(),GetDeliveryPersonPhoneNumber());
	 }*/
	 
	 public void AdminMenu() {
		 int choice;
		 System.out.println("1.Display how many cylinders are delivered on a particular area in a given month");
		 System.out.println("2.How many cylinders are delivered late in a month ");
		 System.out.println("3.Display the name and mobile number, gas connection number who got single cylinder connection");
		 System.out.println("4.Display the customer name address for which particular delivery person is delivered the cylinder");
		 System.out.println("5.Print the report ");
		 System.out.println("6.EXIT");
		 Scanner in=new Scanner(System.in);
		 for(int i=0;i<5;++i) {
			 System.out.print("Enter Choice: ");
			 choice=in.nextInt();
			 if(choice==6)break;
			 	switch(choice) {
			 		case 1:Temp.NumberofCylinderDelivered(D, Index); break;    
			 		case 2:Temp.CylindersDeliveredLateInMonth(D, Index);break;
			 		case 3:Temp.SingleCylinderCustomers(D, Index);break;
			 		case 4:Temp.Customer_DeliveryPerson(D, Index);break;
			 		case 5:Temp.Report(D, Index);break; 
			 	}
		 	}
	 }
	
	 public static void main(String[] args) {
			Book M=new Book();
			for(int i=0;i<2;++i) {
				M.BookGas();
			
			}
	 }
	 
}