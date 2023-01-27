import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;
import java.io.*;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Client implements Serializable{
    private int[] tab = new int[10];

    public static void main(String[] args) {
        new Client();
    }
    public Client(){

        try (Socket client = new Socket("localhost", 9797)) {
            ObjectOutputStream outStream = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream inStream = new ObjectInputStream(client.getInputStream());

            Message sendMessage;
            Message haveMessage;


            System.out.println("Podaj liczbe:");
            Scanner scan = new Scanner(System.in);
            int x = scan.nextInt();
            Random r = new Random();

            for(int i=0;i<10;i++){
                tab[i]= r.nextInt(x-1)+1;
                sendMessage = new Message(tab[i]);
                outStream.writeObject(sendMessage);
            }
            System.out.println("Koniec tworzenia tablicy");


            haveMessage = (Message) inStream.readObject();
            System.out.println(haveMessage.getContent());


            System.out.println("Podaj liczbe:");
            Scanner scann = new Scanner(System.in);

            sendMessage = new Message(scann.nextInt());
            outStream.writeObject(sendMessage);

            int n = sendMessage.getNumber();
            System.out.println("To jest n: " + n);

            haveMessage = (Message) inStream.readObject();
            System.out.println(haveMessage.getContent());


            System.out.println("Wysle " + n + " obiektow");
           Message have;
            for (int i=0;i<n;i++){
                sendMessage = new Message(i);
                outStream.writeObject(sendMessage);

                haveMessage = (Message) inStream.readObject();
                System.out.println(haveMessage.getContent());
            }

            haveMessage = (Message) inStream.readObject();
            System.out.println(haveMessage.getContent());

            inStream.close();
            outStream.close();
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
