package lesson1;

public class Team {
    private String name;
    private TeamMember[] members;

    public Team(String name) {
        this.name = name;
        this.members = new TeamMember[]{
                new TeamMember("Максим", "мужской", 30, new Ability[]{Ability.SWIM, Ability.RUN, Ability.JUMP}),
                new TeamMember("Анна", "женский", 25, new Ability[]{Ability.RUN, Ability.SWIM}),
                new TeamMember("Виталий", "мужской", 45, new Ability[]{Ability.SWIM, Ability.JUMP}),
                new TeamMember("Евгения", "женский", 43, new Ability[]{Ability.SWIM})
        };
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamMember[] getMembers() {
        return members;
    }

    public void teamInfo() {
        System.out.println("Участники команды:");
        for (TeamMember member : members) {
            System.out.printf("Имя: %s, Пол: %s, Возраст: %d\n", member.getName(), member.getGender(), member.getAge());
        }
    }

    public void showResult() {
        for (TeamMember member : members) {
            String ending = member.getCountFinishedObstacles() == 1 ? " испытание" : " испытания";
            System.out.println(member.getName() + " преодолел " + member.getCountFinishedObstacles() + ending);
        }
    }

}
