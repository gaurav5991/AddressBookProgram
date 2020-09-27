import java.util.Scanner;

public class AddressBookMain
{
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Address Book Program");
		
		Scanner sc = new Scanner(System.in);
		
		AddressBook addressBookObj = new AddressBook();
		
		int option;
			
		do
		{
			System.out.println("1.Add Contact");
			
			System.out.println("2.Edit Contact");
			
			System.out.println("3.Exit");

			System.out.println("Enter Choice: ");
				
			option =sc.nextInt();
				
			switch(option)
			{
				case 1:
				{
					System.out.println("Enter First Name: ");
					String firstname = sc.next();
							
					System.out.println("Enter last name: ");
					String lastname = sc.next();
							
					System.out.println("Enter Address: ");
					String address = sc.next();
							
					sc.nextLine();
							
					System.out.println("Enter City: ");
					String city = sc.next();
							
					System.out.println("Enter State: ");
					String state =sc.next();
							
					System.out.println("Enter Zip Code: ");
					int zip = sc.nextInt();
							
					System.out.println("Enter Phone Number:");
					long phonenumber = sc.nextLong();
						
					Contact contact_Obj = new Contact(firstname, lastname, address, city, state, zip, phonenumber);
							
					addressBookObj.addContact(contact_Obj);
							
					break;
				
				}
				case 2:
				{
					System.out.println("Enter the Person First name to edit his/her details: ");
					String person_name = sc.next();
						
					boolean b = addressBookObj.editContact(person_name);
					if(b == true)
					{
						System.out.println("Details Updated");
					}
					else
					{
						System.out.println("Contact Not Found");
					}
						
					break;
				}	
				case 3:
				{
					System.exit(0);
					break;
				}
			}
		}while(option!=3);
		
		sc.close();	
	}		
}
