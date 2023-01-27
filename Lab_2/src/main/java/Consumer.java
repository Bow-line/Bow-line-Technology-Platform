import java.util.Map;
import java.util.TreeMap;
import java.util.List;

public class Consumer {
    private Map<Integer, Boolean> results = new TreeMap<>();
    public synchronized void addResult(int result, boolean prime)
    {
        results.put(result, prime);
    }

    public synchronized void print()
    {
        if(!results.isEmpty())
        {
            for (Map.Entry<Integer, Boolean> pair : results.entrySet())
            {
                System.out.println("Number: " + pair.getKey() + "  Is prime: " + pair.getValue());
            }
        }
        else
        {
            System.out.println("No number detected");
        }
    }
}
