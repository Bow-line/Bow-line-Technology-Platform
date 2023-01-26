import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientsThreads implements Runnable {

    private Socket client;
    private ObjectOutputStream outStream;
    private ObjectInputStream inStream;


    public ClientsThreads(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        outStream = new ObjectOutputStream(client.getOutputStream());
        inStream = new ObjectInputStream(client.getInputStream());
    }

    @Override
    public void run() {
        try {
                Message haveMessage;
                Message sendMessage;

                for(int i=0;i<10;i++){
                    haveMessage = (Message) inStream.readObject();
                    System.out.println(haveMessage.getNumber());
                }
                System.out.println("Tablica przeslana");


                sendMessage = new Message("ready");
                outStream.writeObject(sendMessage);


                haveMessage = (Message) inStream.readObject();
                System.out.println("Wyslana liczba to: " + haveMessage.getNumber());

                int n = haveMessage.getNumber();


                sendMessage = new Message("ready");
                outStream.writeObject(sendMessage);


                System.out.println("Zaraz przyjdzie " + n + " obiektow");




                Message send;
                for (int i=0;i<n;i++){
                    haveMessage = (Message) inStream.readObject();
                    System.out.println(haveMessage.getNumber());

                    sendMessage = new Message("ready");
                    outStream.writeObject(sendMessage);
                }
                System.out.println("Objects were sent");

                sendMessage = new Message("finished");
                outStream.writeObject(sendMessage);


                inStream.close();
                outStream.close();

        } catch (IOException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}