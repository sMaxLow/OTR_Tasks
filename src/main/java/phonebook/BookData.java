package phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class BookData {
    private Map<String, ArrayList<String>> book = new HashMap<>();

    BookData () {
        addToMap("Иванов И.И." , "+8 800 2000 500" ,  "+8 800 200 600");
        addToMap("Петров П.П.", "+8 800 2000 700");
        addToMap("Сидоров С.С.", "+8 800 2000 800", "+8 800 2000 900 ", "+8 800 2000 000");

    }

    protected void  addToMap(String name, String... phoneNumber) {
        ArrayList<String> phoneNumbers = new ArrayList<>();

        Collections.addAll(phoneNumbers, phoneNumber);

        book.put(name, phoneNumbers);
    }

    Map<String, ArrayList<String>> getBook() {
        return book;
    }
}
