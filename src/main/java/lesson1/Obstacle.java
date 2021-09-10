package lesson1;

public class Obstacle {
    private String name;
    private Ability requiredAbility;

    public Obstacle(String name, Ability requiredAbility) {
        this.name = name;
        this.requiredAbility = requiredAbility;
    }

    public Ability getRequiredAbility() {
        return requiredAbility;
    }

    public String getName() {
        return name;
    }
}
