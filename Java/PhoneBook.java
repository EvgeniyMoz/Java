import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        List<String> phoneNumbers = contacts.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);
    }

    public void removeContact(String name) {
        contacts.remove(name);
    }

    public void updateContact(String name, String newPhoneNumber) {
        List<String> phoneNumbers = contacts.get(name);
        if (phoneNumbers != null) {
            phoneNumbers.clear();
            phoneNumbers.add(newPhoneNumber);
        }
    }

    public List<String> getPhoneNumbers(String name) {
        return contacts.getOrDefault(name, new ArrayList<>());
    }

    public void printPhoneBookSortedByPhoneNumberCount() {
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(contacts.entrySet());
        sortedContacts.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        for (int i = sortedContacts.size() - 1; i >= 0; i--) {
            Map.Entry<String, List<String>> entry = sortedContacts.get(i);
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("John", "1234567890");
        phoneBook.addContact("John", "9876543210");
        phoneBook.addContact("Alice", "5555555555");
        phoneBook.addContact("Bob", "9999999999");

        phoneBook.printPhoneBookSortedByPhoneNumberCount();
    }
}
