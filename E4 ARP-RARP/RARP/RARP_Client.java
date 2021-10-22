import java.util.*;
import java.net.*;
import java.io.*;


public class RARP_Client{
    public static void main(String args[]){

        try{
            byte[] sendbyte = new byte[1024];
            byte[] receivebyte = new byte[1024];
            
            //Create a Datagram Socket class object
            DatagramSocket Client = new DatagramSocket();
            InetAddress address = InetAddress.getByName("127.0.0.1");

            //Get the mac address from the client
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("ENTER THE PHYSICAL ADDRESS [MAC] : ");
            String mac = input.readLine();

            //Send the received mac address to the server
            sendbyte = mac.getBytes();
            DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, address, 2000);
            Client.send(sender);

            //This returns the ip address from the server
            DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
            Client.receive(receiver);
            String ip = new String(receiver.getData());
            System.out.print("THE IP ADDRESS FOR THE GIVEN MAC[ "+mac+" ] ADDRESS IS : "+ ip);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}