import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        int howManyThreads = Integer.parseInt(args[0]);
        Resource resource = new Resource();
        Consumer results = new Consumer();
        Producer products = new Producer(resource, results);
        List<Thread> allTheThreads = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String command = "start";

        for(int i =0; i < howManyThreads; i++)
        {
            Thread thread = new Thread(products);
            thread.start();
            allTheThreads.add(thread);
        }

        while(command.compareTo("end") != 0)
        {
            command = scanner.nextLine();
            if(command.compareTo("add")==0)
            {
                command = scanner.nextLine();
                int toAdd = Integer.parseInt(command);
                resource.put(toAdd);
            }
            if(command.compareTo("print") == 0)
            {
                results.print();
            }
        }

        for( Thread thread: allTheThreads)
        {
            thread.interrupt();
        }
        for(Thread thread: allTheThreads)
        {
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {

            }
        }

    }
}
