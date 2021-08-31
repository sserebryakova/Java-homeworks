package lesson1;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Спарта");

        System.out.println("Название команды: " + team.getName());

        team.teamInfo();

        Course course = new Course();
        course.doIt(team);
        team.showResult();
    }
}
