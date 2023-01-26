import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public class MageController {

    @Getter
    @Setter
    private MageRepository repository;

    public MageController(){
        this.repository = new MageRepository();
    }

    public String find(String name) {
        Optional<Mage> theMage = repository.find(name);
        if(theMage.isEmpty())
        {
            return "not found";
        }
        else
            return theMage.toString();
    }
    public String delete(String name) {
        Optional<Mage> theMage = repository.find(name);
        if(theMage.isEmpty())
        {
            return "not found";
        }
        else {
            repository.delete(name);
            return "done";
        }

    }
    public String save(String name, String level) {
        Optional<Mage> theMage = repository.find(name);
        if(theMage.isEmpty())
        {
            repository.save(new Mage(name,Integer.parseInt(level)));
            return "done";
        }
        else {
            return "bad request";
        }
    }

}