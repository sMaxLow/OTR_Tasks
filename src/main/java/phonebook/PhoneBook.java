package phonebook;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        int count;
        BookData bookData = new BookData();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String input = scanner.nextLine();
        scanner.close();
        if (bookData.getBook().containsKey(input)) {
            count = 1;
            ArrayList<String> phoneNumbers = bookData.getBook().get(input);
            for (String number : phoneNumbers){
                System.out.println(count + ". " + number);
                count ++;
            }
        } else
            System.out.println("this name is not in the phone book");


    }
}
