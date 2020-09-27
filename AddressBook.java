import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook 
{
	Scanner scan = new Scanner(System.in);

	ArrayList<Contact> contact_list = new ArrayList<Contact>();
	
	public void setList(ArrayList<Contact> list) 
	{
		this.contact_list = contact_list;
	}
	
	public ArrayList<Contact> getList()
	{
		return contact_list;
	}

	public void addContact(Contact contact)
	{
		contact_list.add(contact);
	}
	public boolean editContact(String Name)
	{
		int flag = 0;
		for(Contact contact: contact_list)
		{
			if(contact.getFirst_name().equals(Name))
			{
				System.out.println("Enter the detail which needs to be updated:");
				
				System.out.println("1.First Name");
				System.out.println("2.Last Name");
				System.out.println("3.Address");
				System.out.println("4.City");
				System.out.println("5.State");
				System.out.println("6.ZipCode");
				System.out.println("7.Phone Number");

				System.out.println("Choose Option");				

				int choice = scan.nextInt();
				switch(choice)
				{
					case 1:
					{
						System.out.println("Enter First Name: ");
						String firstname = scan.next();
						contact.setFirst_name(firstname);
						break;
					}
					case 2:
					{
						System.out.println("Enter last name: ");
						String lastname = scan.next();
						contact.setLast_name(lastname);
						break;
					}
					case 3:
					{
						System.out.println("Enter Address: ");
						String address = scan.next();
						contact.setAddress(address);
						break;
					}
					case 4:
					{
						System.out.println("Enter City: ");
						String city = scan.next();
						contact.setCity(city);
						break;
					}
					case 5:
					{
						System.out.println("Enter State: ");
						String state =scan.next();
						contact.setState(state);
						break;
					}
					case 6:
					{
						System.out.println("Enter Zip Code: ");
						int zip = scan.nextInt();
						contact.setZip_code(zip);
						break;
					}
					case 7:
					{
						System.out.println("Enter Phone Number:");
						long phonenumber = scan.nextLong();
						contact.setPhone_number(phonenumber);
						break;
					}
				}
				
				flag = 1;
				break;
			}
		}
		if(flag==1)
			return true;
		else
			return false;
	}
}
