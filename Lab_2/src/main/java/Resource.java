import java.util.List;
import java.util.ArrayList;


public class Resource {

    private List<Integer> addedNumbers = new ArrayList<>();

    public synchronized Integer take() throws InterruptedException
    {
        while(addedNumbers.isEmpty())
        {
            wait();
        }
        return addedNumbers.remove(0);
    }

    public synchronized void put(int p)
    {
        addedNumbers.add(p);
        notifyAll();
    }

    public List<Integer> getAddedNumbers() {

        return addedNumbers;
    }

    public void setAddedNumbers(List<Integer> numbers) {
        this.addedNumbers = numbers;
    }

}