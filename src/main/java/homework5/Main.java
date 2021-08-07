package homework5;

public class Main {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Иванов Иван Иванович", "Инженер", "ivivan@mailbox.com", "892312312", 30000, 35);
        persArray[1] = new Person("Петров Пётр Петрович", "Менеджер", "ppetrov@mailbox.com", "89062358910", 25000, 45);
        persArray[2] = new Person("Сидорова Мария Сергеевна", "Администратор","msidorova@mailbox.com", "89605236589", 23000, 25);
        persArray[3] = new Person("Серова Татьяна Михайловна", "Старший инженер", "tserova@mailbox.com", "89605234875", 50000, 48);
        persArray[4] = new Person("Григорьев Александр Ильич", "Менеджер", "agrigoriev@mailbox.com", "89102345698",25000,28);

        for (Person p : persArray) {
            if (p.getAge() > 40) {
                p.getInfo();
            }
        }
    }
}
