import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class School {
    @Id
    private String name;
    private int influence;

    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER)
    private List<Wizard> wizards;

    public School(String name, int influence)
    {
        this.name = name;
        this.influence = influence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return influence;
    }

    public void setHeight(int influence) {
        this.influence = influence;
    }

    public List<Wizard> getWizards() {
        return wizards;
    }

    public void setWizards(List<Wizard> wizards) {
        this.wizards = wizards;
    }

    public void addMage(Wizard wizard)
    {
        wizards.add(wizard);
    }

    @PreRemove
    private void preRemove()
    {
        for (Wizard wizard : wizards)
        {
            wizard.setSchool(null);
        }
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' + '}';
    }
}
