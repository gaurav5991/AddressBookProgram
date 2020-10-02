import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain
{
	static Scanner sc = new Scanner(System.in);
	public static Map<String, AddressBook> addressBookMap;
	static AddressBook AddBookObj = new AddressBook();
	public AddressBookMain() {
		addressBookMap = new HashMap<>();
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		AddressBook obj = new AddressBook();
		AddressBookMain AddBookMain = new AddressBookMain();
		boolean bool = true;
		while(bool){
			System.out.println("1.Add New Address Book");

			System.out.println("2.Search contact By State");

			System.out.println("3.Search Contact by city");

			System.out.println("4.Search contact By State Using State and Person  Dictionary");

			System.out.println("5.Search Contact by city Using City and Person Dictionary");

			System.out.println("6.Count Contact By State");

			System.out.println("7.Count Contact By City");

			System.out.println("8.Exit");

			System.out.println("Enter Choice: ");

			int option = sc.nextInt();

			switch (option)
			{
				case 1:{
					System.out.println("Enter the Name of Address Book to be Added: ");
					String addressBookName = sc.next();
					if(addressBookMap.containsKey(addressBookName)){
						System.out.println("Address Book Already exists");
						break;
					}else{
						AddBookMain.addAddressBook(addressBookName);
						break;
					}
				}
				case 2: {
					System.out.println("Enter Name of State: ");
					String StateName = sc.next();
					AddBookMain.searchPersonByState(StateName);
					break;
				}
				case 3: {
					System.out.println("Enter Name of City: ");
					String CityName = sc.next();
					AddBookMain.searchPersonByCity(CityName);
					break;
				}
				case 4:{
					System.out.println("Enter Name of State: ");
					String StateName = sc.next();
					AddBookMain.searchPersonByStateUsinHashMap(StateName);
					break;
				}
				case 5: {
					System.out.println("Enter Name of City: ");
					String CityName = sc.next();
					AddBookMain.searchPersonByCityUsinghashmap(CityName);
					break;
				}
				case 6: {
					System.out.println("Enter Name of State: ");
					String StateName = sc.next();
					AddBookMain.CountByState(StateName);
					break;
				}
				case 7:{
					System.out.println("Enter Name of City: ");
					String CityName = sc.next();
					AddBookMain.CountByCity(CityName);
					break;
				}
				case 8:{
					break;
				}
			}
		}
	}
	public void  addAddressBook(String addressBookName){

		boolean flag = true;
		while(flag){
			System.out.println("1.Add Contact");

			System.out.println("2.Edit Contact");

			System.out.println("3.Delete Contact");

			System.out.println("4.Exit");

			System.out.println("Enter Choice: ");

			int option = sc.nextInt();

			switch (option)
			{
				case 1: {
					AddBookObj.addContact();
					break;
				}
				case 2: {
					System.out.println("Enter the Person First name to edit details: ");
					String person_name = sc.next();

					boolean b = AddBookObj.editContact(person_name);
					if (b == true) {
						System.out.println("Details Updated");
					} else {
						System.out.println("Contact Not Found");
					}
					break;
				}
				case 3: {
					System.out.println("Enter the Contact to be deleted:");
					String Name = sc.next();

					boolean b1 = AddBookObj.deleteContact(Name);
					if (b1 == true) {
						System.out.println("Details Deleted");
					} else {
						System.out.println("Contact Not Found");
					}
					break;
				}
				case 4: {
					flag =false;
					break;
				}
			}
		}
		addressBookMap.put(addressBookName, AddBookObj);
		System.out.println("Address Book Added Successfully");
	}

	public void searchPersonByState(String state){
		for(Map.Entry<String, AddressBook> set: addressBookMap.entrySet()){
			for (int i = 0; i < (set.getValue()).contact_list.size(); i++) {

				Contact contact = (Contact)set.getValue().contact_list.get(i);

				if(state.equals(contact.getState())){
					System.out.println("Address Book: "+set.getKey());
					System.out.println("First Name: "+contact.getFirst_name());
					System.out.println("Last Name: "+contact.getLast_name());
					System.out.println("Address: "+contact.getAddress());
					System.out.println("City: "+contact.getCity());
					System.out.println("State: "+contact.getState());
					System.out.println("Zip Code: "+contact.getZip_code());
					System.out.println("Phone Number: "+contact.getPhone_number());
					System.out.println("Email: "+contact.getEmail());

				}
			}
		}
	}
	public void searchPersonByCity(String city){
		for(Map.Entry<String, AddressBook> set: addressBookMap.entrySet()){
			for (int i = 0; i < (set.getValue()).contact_list.size(); i++) {
				Contact contact = (Contact)set.getValue().contact_list.get(i);

				if(city.equals(contact.getCity())){
					System.out.println("Address Book: "+set.getKey());
					System.out.println("First Name: "+contact.getFirst_name());
					System.out.println("Last Name: "+contact.getLast_name());
					System.out.println("Address: "+contact.getAddress());
					System.out.println("City: "+contact.getCity());
					System.out.println("State: "+contact.getState());
					System.out.println("Zip Code: "+contact.getZip_code());
					System.out.println("Phone Number: "+contact.getPhone_number());
					System.out.println("Email: "+contact.getEmail());
				}
			}
		}
	}

	public void searchPersonByStateUsinHashMap(String state_name){
		Contact contact = AddBookObj.ContactByState.get(state_name);
		System.out.println("First Name: "+contact.getFirst_name());
		System.out.println("Last Name: "+contact.getLast_name());
		System.out.println("Address: "+contact.getAddress());
		System.out.println("City: "+contact.getCity());
		System.out.println("State: "+contact.getState());
		System.out.println("Zip Code: "+contact.getZip_code());
		System.out.println("Phone Number: "+contact.getPhone_number());
		System.out.println("Email: "+contact.getEmail());
	}

	public void searchPersonByCityUsinghashmap(String City){
		Contact contact = AddBookObj.ContactByCity.get(City);
		System.out.println("First Name: "+contact.getFirst_name());
		System.out.println("Last Name: "+contact.getLast_name());
		System.out.println("Address: "+contact.getAddress());
		System.out.println("City: "+contact.getCity());
		System.out.println("State: "+contact.getState());
		System.out.println("Zip Code: "+contact.getZip_code());
		System.out.println("Phone Number: "+contact.getPhone_number());
		System.out.println("Email: "+contact.getEmail());
	}
	public void CountByState(String state) {
		int count = 0;
		for(Map.Entry<String, AddressBook> entry: addressBookMap.entrySet()){
			for(int i=0;i<(entry.getValue()).contact_list.size();i++)
			{
				Contact contact= entry.getValue().contact_list.get(i);

				if(state.equals(contact.getState()))
				{
					count++;
				}

			}
		}
		System.out.println("Total Person Count in state: "+state+": "+count);
	}
	public void CountByCity(String city) {
		int count=0;
		for(Map.Entry<String, AddressBook> entry: addressBookMap.entrySet())
		{
			for(int i=0;i<(entry.getValue()).contact_list.size();i++)
			{
				Contact d= (Contact)entry.getValue().contact_list.get(i);

				if(city.equals(d.getCity()))
				{
					count++;
				}

			}
		}
		System.out.println("Total number of people in this city: "+city+": "+count);
	}
}
