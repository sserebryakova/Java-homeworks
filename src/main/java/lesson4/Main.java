package lesson4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] words = {"кот", "мышь", "пёс", "дятел", "лягушка", "кот", "мышь", "кот", "павлин", "волк", "жираф",
                "медведь", "лиса"};
        Map<String, Integer> countWords = new HashMap<>();
        for (String word : words) {
            if (countWords.containsKey(word)) {
                countWords.put(word, countWords.get(word) + 1);
            } else {
                countWords.put(word, 1);
            }
        }
        System.out.println(countWords.keySet());

        for (String key : countWords.keySet()) {
            System.out.println(key + " : " + countWords.get(key));
        }
    }
}
