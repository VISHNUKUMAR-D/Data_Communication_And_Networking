import java.util.*;
import java.io.*;
import java.net.*;



public class ARP_Server{
    public static void main(String args[]){

        try{
            while(true){
                byte[] sendbyte = new byte[1024];
                byte[] receivebyte = new byte[1024];
                
                //Create a Datagram Socket class object
                DatagramSocket Server = new DatagramSocket(2000);

                DatagramPacket receiver = new DatagramPacket(receivebyte, receivebyte.length);
                Server.receive(receiver);

                //Get the data from the Client
                String str = new String(receiver.getData());
                String data = str.trim();

                //Get the address of the client
                InetAddress address = receiver.getAddress();

                //Get the port number from the client
                int port_number = receiver.getPort();

                //Availability of mac address and their corresponding mac address in the server
                String ip[]={"165.165.80.80","165.165.79.1"}; 
                String[] mac={"74-4C-A1-4E-EF-12","08-8F-C3-05-E9-13"};

                //Check for the existance of the ip address given by the client
                for(int i=0; i<mac.length; i++){
                    if(data.equals(ip[i])){
                        sendbyte = mac[i].getBytes();
                        DatagramPacket sender = new DatagramPacket(sendbyte, sendbyte.length, address, port_number);
                        Server.send(sender);
                        break;
                    }
                }
                break;
            }
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
}