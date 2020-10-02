import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain
{
	static Scanner sc = new Scanner(System.in);
	public static Map<String, AddressBook> addressBookMap;

	public AddressBookMain() {
		addressBookMap = new HashMap<>();
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");

		AddressBookMain AddBookMain = new AddressBookMain();

		System.out.println("Enter the Number of Address Books to be Added: ");
		int numberOfAddressBook = sc.nextInt();

		for (int i = 0; i < numberOfAddressBook; i++) {
			System.out.println("Enter The Name of Address Book: ");
			String addressBookName = sc.next();
			if(addressBookMap.containsKey(addressBookName)){
				System.out.println("Address Book Already exists");
			}else{
				AddBookMain.addAddressBook(addressBookName);
			}
		}
	}

	public void  addAddressBook(String addressBookName){
		AddressBook AddBookObj = new AddressBook();
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
}
