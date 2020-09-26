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
}
