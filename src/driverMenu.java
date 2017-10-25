import java.sql.SQLException;
import java.util.Scanner;

import com.BridgeLabz.utility.utility;

public class driverMenu {

	public static void main(String[] args) throws Exception {
		int choice;
		
		Scanner scanner=new Scanner(System.in);
		
		do {
			System.out.println("Enter the choice........");
			System.out.println("1.Insert Data....");
			System.out.println("2.Delete Data....");
			System.out.println("3.Update Data....");
			System.out.println("4.Display.....");
			System.out.println("5.exit.......");
			choice=scanner.nextInt();
			
			switch(choice) {
			case 1:utility.insertPreparedStatement();
			       break;
			case 2:utility.deleteRecord();
			       break;
			case 3:utility.updateRecord();
			       break;
			case 4:utility.displayRecord();
			       break;
			case 5:System.exit(0);
			       break;
			       
			}
		}while(choice<5);
	}

}
