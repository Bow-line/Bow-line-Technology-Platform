import org.junit.jupiter.api.Test;

import java.util.Objects;

public class MageControllerTest {

    @Test
    public void testTheSave_forPositiveOutcome(){
        MageController mageControll = new MageController();

        String result = mageControll.save("Gandalf","50");
        assert Objects.equals(result, "done") : "Should be done";
        System.out.println(result);

        String result2 = mageControll.save("Saruman","80");
        assert Objects.equals(result2, "done") : "Should be done";
        System.out.println(result2);

    }
    @Test
    public void testTheSave_forInvalidOutcome(){
        MageController mageControll = new MageController();

        String result = mageControll.save("Gandalf","50");
        assert Objects.equals(result, "done") : "Should be done";
        System.out.println(result);

        String result2 = mageControll.save("Gandalf","80");
        assert Objects.equals(result2, "bad request") : "Should be bad request";
        System.out.println(result2);
    }
    @Test
    public void testTheFind_forPositiveOutcome(){
        MageController mageControll = new MageController();

        System.out.println(mageControll.save("Gandalf","50"));
        System.out.println(mageControll.save("Saruman","80"));
        System.out.println(mageControll.save("Radagast","30"));

        System.out.println(mageControll.find("Radagast"));


    }
    @Test
    public void testTheFind_forInvalidOutcome(){
        MageController mageControll = new MageController();

        System.out.println(mageControll.save("Gandalf","50"));
        System.out.println(mageControll.save("Saruman","80"));
        System.out.println(mageControll.save("Radagast","30"));

        String result = mageControll.find("Dumbledor");
        assert Objects.equals(result, "not found") : "Should be not found";
        System.out.println(result);

    }
    @Test
    public void testTheDelete_forPositiveOutcome(){
        MageController mageControll = new MageController();

        System.out.println(mageControll.save("Gandalf","50"));
        System.out.println(mageControll.save("Saruman","80"));
        System.out.println(mageControll.save("Radagast","30"));

        String result = mageControll.delete("Gandalf");
        assert Objects.equals(result, "done") : "Should be done";
        System.out.println(result);
    }
    @Test
    public void testTheDelete_forInvalidOutcome(){
        MageController mageControll = new MageController();

        System.out.println(mageControll.save("Gandalf","50"));
        System.out.println(mageControll.save("Saruman","80"));
        System.out.println(mageControll.save("Radagast","30"));

        String result = mageControll.delete("Dumbledor");
        assert Objects.equals(result, "not found") : "Should be not found";
        System.out.println(result);
    }
}
