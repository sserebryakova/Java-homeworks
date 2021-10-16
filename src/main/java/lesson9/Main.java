package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Татьяна", Arrays.asList(new Course("Java-разработка"), new Course("Проджект-менеджмент"),
                new Course("Тестирование"))));
        students.add(new Student("Ольга", Arrays.asList(new Course("Проджект-менеджмент"), new Course("Веб-разработка"),
                new Course("Python-разработка"), new Course("Тестирование"))));
        students.add(new Student("Павел", Arrays.asList(new Course("Java-разработка"), new Course("Веб-разработка"),
                new Course("Искусственный интеллект"), new Course("Бизнес-аналитика"))));
        students.add(new Student("Александр", Arrays.asList(new Course("Информационная безопасность"), new Course("Python-разработка"),
                new Course("Искусственный интеллект"), new Course("Тестирование"))));

        System.out.println("Список уникальных курсов: " + students.stream()
                .map(Student::getCourses)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet()));

        System.out.println("Список любознательных студенов : " + students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList()));

        Course course = new Course("Тестирование");
        System.out.println("Список студенов, посещающих курс Тестирования : " + students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
