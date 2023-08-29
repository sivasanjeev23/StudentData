package practice;
import java.sql.SQLException;
import java.util.Scanner;
public class StudentData {

	public static void main(String[] args) {
		try {
			Sportal sp=new Sportal();
			Scanner sc=new Scanner(System.in);
			System.out.println("Welcome to Student portal");
			System.out.println("1. Add Student\n2. View Student\n3. Edit Student\n4. Remove Student");
			int n=sc.nextInt();
			if(n==1) {
				System.out.println("Enter Regno");
				int regno=sc.nextInt();sc.nextLine();
				System.out.println("Enter Name");
				String name=sc.nextLine();
				System.out.println("Enter Dob");
				String dob=sc.nextLine();
				System.out.println("Enter M for Male F for Female");
				String gender=sc.nextLine();
				System.out.println("Enter Course");
				String course=sc.nextLine();
				System.out.println("Enter Fees");
				int fees=sc.nextInt();
				sc.close();
				System.out.println(sp.add(regno,name,dob,gender,course,fees)+" row(s) affected");
			}
			else if(n==2) {
				sc.close();
				sp.view();
			}
			else if(n==3) {
				System.out.println("Enter Regno ");
				int regno=sc.nextInt();
				System.out.println("Enter fees");
				int fees=sc.nextInt();
				sc.close();
				System.out.println(sp.edit(regno,fees)>0?"Updated":"Not Updated");
			}
			else if(n==4) {
				System.out.println("Enter Regno");
				int regno=sc.nextInt();sc.close();
				System.out.println(sp.remove(regno)>0?"Removed":"Not Removed");
			}
			else {
				System.out.println("Invalid Option");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
