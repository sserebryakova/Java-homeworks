package homework5;

public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }

    public void getInfo() {
        System.out.println("ФИО-" + name + "; " + "Должность-" + position + "; " + "Email-" + email + "; " + "Телефон-" + phone + "; " + "Зарплата-" + salary + "; " + "Возраст-" + age);
    }

}
