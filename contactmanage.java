
package contactmanagement;



import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void displayContact() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("-------------------------------");
    }
}

public class contactmanage {

    private static ArrayList<Contact> contactList = new ArrayList<>();

    public static void addContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();

        System.out.println("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter email address: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber, email);
        contactList.add(newContact);
        System.out.println("Contact added successfully!");
    }

    public static void viewContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contactList) {
                contact.displayContact();
            }
        }
    }

    public static void searchContact() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the contact to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;

        for (Contact contact : contactList) {
            if (contact.getName().equalsIgnoreCase(searchName)) {
                contact.displayContact();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n*** Contact Management System ***");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}
