import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@AllArgsConstructor
public class Mage {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int level;

}

