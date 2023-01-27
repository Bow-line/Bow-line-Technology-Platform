public class Producer implements Runnable {
    private Resource  resource;
    private Consumer consumer;
    public Producer(Resource resource, Consumer consumer) {
        this.resource = resource;
        this.consumer = consumer;
    }
    @Override
    public void run() {
        try
        {
            while(!Thread.interrupted())
            {
                int number = resource.take();
                boolean prime = true;
                int m = number/2;
                int flag = 0;
                for(int i = 2; i <= m; i++)
                {
                    if(number % i == 0)
                    {
                        prime = false;
                        flag = 1;
                        break;
                    }
                }
                if (flag==0) {
                    prime = true;
                }

                consumer.addResult(number, prime);
            }
        }
        catch (InterruptedException e)
        {

        }
    }
}
