import java.util.*;
import java.net.*;
import java.io.*;


public class ARP_Client{
    public static void main(String args[]){

        try{
            byte[] sendbyte = new byte[1024];
            byte[] receivebyte = new byte[1024];
            
            //Create a Datagram Socket class object
            DatagramSocket Client = new DatagramSocket();
            InetAddress address = InetAddress.getByName("127.0.0.1");

            //Get the ip address from the client
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("ENTER THE PHYSICAL ADDRESS [IP] : ");
            String ip = input.readLine();

            //Send the received ip address to the server
            sendbyte = ip.getBytes();
            DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, address, 2000);
            Client.send(sender);

            //This returns the mac address from the server
            DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
            Client.receive(receiver);
            String mac = new String(receiver.getData());
            System.out.print("THE IP ADDRESS FOR THE GIVEN IP[ "+ip+" ] ADDRESS IS : "+ mac);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}