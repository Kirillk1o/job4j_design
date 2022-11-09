package ru.job4j.serialization.json;

import java.util.Arrays;

public class Archer {
    private final boolean sex;
    private final int range;
    private final ArcherSkills skills;
    private final  String race;
    private final String[] status;

    public Archer(boolean sex, int range, ArcherSkills skills, String race, String[] status) {
        this.sex = sex;
        this.range = range;
        this.skills = skills;
        this.race = race;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Archer{"
                + "sex=" + sex
                + ", range=" + range
                + ", skills=" + skills
                + ", race='" + race + '\''
                + ", status=" + Arrays.toString(status)
                + '}';
    }
}
