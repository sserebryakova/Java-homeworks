package lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    Map<String, List<String>> contacts = new HashMap<>();

    public void add(String name, String phone) {
        if (contacts.containsKey(name)) {
            contacts.get(name).add(phone);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            contacts.put(name, phones);
        }
    }

    public List<String> get(String name) {
        return contacts.getOrDefault(name, new ArrayList<>());
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Петров", "89235689752");
        pb.add("Петров", "89542368954");
        pb.add("Петров", "89223645898");
        pb.add("Сидоров", "89252345685");
        pb.add("Иванов", "89275849752");
        pb.add("Сергеев", "89267524581");
        pb.add("Сергеев", "89867254583");

        for (String name : pb.contacts.keySet()) {
            System.out.println(name + " : " + pb.get(name));
        }
        System.out.println("Пушкин" + " : " + pb.get("Пушкин"));
    }
}
