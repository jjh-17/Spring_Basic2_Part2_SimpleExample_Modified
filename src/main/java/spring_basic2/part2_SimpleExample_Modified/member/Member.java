package spring_basic2.part2_SimpleExample_Modified.member;

public class Member {
    private long id;
    private String name;
    private Gradle gradle;

    public Member(long id, String name, Gradle gradle) {
        this.id = id;
        this.name = name;
        this.gradle = gradle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gradle getGradle() {
        return gradle;
    }

    public void setGradle(Gradle gradle) {
        this.gradle = gradle;
    }
}
