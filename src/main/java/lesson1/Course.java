package lesson1;

public class Course {
    private Obstacle[] obstacles;

    public Course() {
        this.obstacles = new Obstacle[]{
                new Obstacle("проплыть 100 метров", Ability.SWIM),
                new Obstacle("пробежать 1 километр", Ability.RUN),
                new Obstacle("прыгнуть в длину 1,5 метра", Ability.JUMP)
        };

    }
    public void doIt(Team team) {
        for (TeamMember member : team.getMembers()) {
            for (Obstacle obstacle : obstacles) {
                System.out.printf("Участник %s приступил к испытанию %s\n", member.getName(), obstacle.getName());
                for (Ability ability : member.getAbilities()) {
                    if (ability == obstacle.getRequiredAbility()) {
                        member.setCountFinishedObstacles(1 + member.getCountFinishedObstacles());
                    }
                }
            }
        }
    }


}
