

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Wizard {

    @Id
    private String name;
    private int level;
    @ManyToOne
    private School school;

    public Wizard(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
        if (school != null)
            school.addMage(this);
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "name='" + name + '\''
                + '}';
    }
}
