package ru.job4j.serialization.json;

public class ArcherSkills {
    private String atack;

    public ArcherSkills(String atack) {
        this.atack = atack;
    }

    @Override
    public String toString() {
        return "ArcherSkills{"
                + "atack='" + atack + '\''
        + '}';
    }
}
