import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;


public class PhoneBook {
    private HashMap<String, List<String>> phones = new HashMap<>();

    public void addRecord(String name, String number) {
        if (phones.containsKey(name)) {
            List<String> list = phones.get(name);

            if (!list.contains(number)) {
                list.add(number);
            }
        } else {
            List<String> list = new ArrayList<>();
            list.add(number);

            phones.put(name, list);
        }
    }

    private void printRecords() {
        phones
        .entrySet()
        .stream()
        .sorted((first, second) -> second.getValue().size() - first.getValue().size())
        .forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        
        phoneBook.addRecord("Ivanov Ivan", "+375291276587");
        phoneBook.addRecord("Ivanov Ivan", "+48528953768");
        phoneBook.addRecord("Ivanov Ivan", "+48511432965");
        
        phoneBook.addRecord("Smith John", "+375296751318");
        phoneBook.addRecord("Smith John", "+48652284670");

        phoneBook.addRecord("Smirnov Igor", "+375291398176");

        phoneBook.addRecord("Pekacki Kryzstov", "+48591611322");

        phoneBook.printRecords();
    }
}