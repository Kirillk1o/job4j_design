package ru.job4j.serialization.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
@XmlRootElement(name = "archer")
@XmlAccessorType(XmlAccessType.FIELD)

public class Archer {
    @XmlAttribute
    private boolean sex;
    @XmlAttribute
    private int range;

    private ArcherSkills skills;
    @XmlAttribute
    private String race;
    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] statuses;

    public Archer(boolean sex, int range, ArcherSkills skills, String race, String[] status) {
        this.sex = sex;
        this.range = range;
        this.skills = skills;
        this.race = race;
        this.statuses = status;
    }
    public Archer() {
    }

    public boolean isSex() {
        return sex;
    }

    public int getRange() {
        return range;
    }

    public ArcherSkills getSkills() {
        return skills;
    }

    public String getRace() {
        return race;
    }

    public String[] getStatuses() {
        return statuses;
    }

    @Override
    public String toString() {
        return "Archer{"
                + "sex=" + sex
                + ", range=" + range
                + ", skills=" + skills
                + ", race='" + race + '\''
                + ", status=" + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Archer archer = new Archer(false, 234, new ArcherSkills("Shoots fire arrows"),
                "Elf", new String[] {"Alive", "Light"});
        JAXBContext context = JAXBContext.newInstance(Archer.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(archer, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
