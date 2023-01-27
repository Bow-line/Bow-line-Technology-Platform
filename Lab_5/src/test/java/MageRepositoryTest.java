import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MageRepositoryTest {

    @Test
    public void testTheSave_forPositiveOutcome(){
        Mage mage1 = new Mage("Gandalf",50);
        Mage mage2 = new Mage("Saruman",80);
        Mage mage3 = new Mage("Radagast",30);
        Mage mage4 = new Mage("Radagast",15);
        MageRepository mageRep = new MageRepository();


        System.out.println(mage1.toString());
        mageRep.save(mage1);
        System.out.println(mage2.toString());
        mageRep.save(mage2);
        System.out.println(mage3.toString());
        mageRep.save(mage3);


    }
    @Test
    public void testTheSave_forInvalidOutcome(){
        Mage mage3 = new Mage("Radagast",30);
        Mage mage4 = new Mage("Radagast",15);
        MageRepository mageRep = new MageRepository();
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            System.out.println(mage3.toString());
            mageRep.save(mage3);
            System.out.println(mage4.toString());
            mageRep.save(mage4);
        }, "The Exception haven't happened");

        System.out.println(thrown.getMessage());
    }
    @Test
    public void testTheFind_forPositiveOutcome(){
        Mage mage1 = new Mage("Gandalf",50);
        Mage mage2 = new Mage("Saruman",80);
        Mage mage3 = new Mage("Radagast",30);
        MageRepository mageRep = new MageRepository();
        mageRep.save(mage1);
        mageRep.save(mage2);
        mageRep.save(mage3);

        System.out.println(mageRep.find("Gandalf"));
    }
    @Test
    public void testTheFind_forInvalidOutcome(){
        Mage mage1 = new Mage("Gandalf",50);
        Mage mage2 = new Mage("Saruman",80);
        Mage mage3 = new Mage("Radagast",30);
        MageRepository mageRep = new MageRepository();
        mageRep.save(mage1);
        mageRep.save(mage2);
        mageRep.save(mage3);

        System.out.println(mageRep.find("Dumbledor"));
    }
    @Test
    public void testTheDelete_forPositiveOutcome(){
        Mage mage1 = new Mage("Gandalf",50);
        Mage mage2 = new Mage("Saruman",80);
        Mage mage3 = new Mage("Radagast",30);
        MageRepository mageRep = new MageRepository();
        mageRep.save(mage1);
        mageRep.save(mage2);
        mageRep.save(mage3);

        mageRep.delete("Gandalf");
    }
    @Test
    public void testTheDelete_forInvalidOutcome(){

        Mage mage1 = new Mage("Gandalf",50);
        Mage mage2 = new Mage("Saruman",80);
        Mage mage3 = new Mage("Radagast",30);
        MageRepository mageRep = new MageRepository();
        mageRep.save(mage1);
        mageRep.save(mage2);
        mageRep.save(mage3);

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            mageRep.delete("Dumbledor");
        }, "The Exception haven't happened");
        System.out.println(thrown.getMessage());
    }
}
