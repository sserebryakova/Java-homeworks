package lesson1;

public class TeamMember {
    private String name;
    private String gender;
    private int age;
    private int countFinishedObstacles = 0;
    private Ability[] abilities;

    public TeamMember(String name, String gender, int age, Ability[] abilities) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCountFinishedObstacles() {
        return countFinishedObstacles;
    }

    public void setCountFinishedObstacles(int countFinishedObstacles) {
        this.countFinishedObstacles = countFinishedObstacles;
    }

    public Ability[] getAbilities() {
        return abilities;
    }
}
