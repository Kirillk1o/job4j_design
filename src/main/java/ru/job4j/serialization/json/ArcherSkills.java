package ru.job4j.serialization.json;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ArchaerSkills")
public class ArcherSkills {

    @XmlAttribute
    private String atack;

    public ArcherSkills(String atack) {
        this.atack = atack;
    }

    public ArcherSkills() {
    }

    public String getAtack() {
        return atack;
    }


    @Override
    public String toString() {
        return "ArcherSkills{"
                + "atack='" + atack + '\''
                + '}';
    }
}
