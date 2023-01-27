import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class MageRepository {

    @Getter
    @Setter
    private Collection<Mage> collection;
    public MageRepository(){
        this.collection = new ArrayList<>();
    }

    public Optional<Mage> find(String name) {
        Optional<Mage> theMage = Optional.empty();
        for (Mage m: collection){
            if(Objects.equals(m.getName(), name)){
                theMage = Optional.of(m);
            }
        }
        if(theMage.isEmpty()){
            return Optional.empty();
        }
        else {
            return theMage;
        }

    }

    public void delete(String name) {
        Optional<Mage> theMage = find(name);
        if(theMage.isEmpty()){
            throw new IllegalArgumentException("not found");
        }
        else {
            collection.remove(theMage);
            System.out.println("Mage has been removed");
        }

    }

    public void save(Mage mage) {
            Optional<Mage> theMage = find(mage.getName());
            if (theMage.isEmpty()) {
                collection.add(mage);
                System.out.println("Mage has been saved");
            } else {
                throw new IllegalArgumentException("bad request");
            }
        }
}
