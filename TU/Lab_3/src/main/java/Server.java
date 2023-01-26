import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private  ArrayList<ClientsThreads> clients = new ArrayList<>();
    private int howManyClients = 3;
    private  ExecutorService stop = Executors.newFixedThreadPool(howManyClients);

    public static void main(String[] args) {
        new Server();


    }
    public Server(){
        try (ServerSocket server = new ServerSocket(9797)) {

                for(int i=0;i<howManyClients;i++) {
                    System.out.println("Gonna connect");
                    Socket socket = server.accept();
                    ClientsThreads threads = new ClientsThreads(socket);
                    clients.add(threads);
                    stop.execute(threads);
                }
                server.close();

            } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }

