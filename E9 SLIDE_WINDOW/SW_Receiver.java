/*
                        ALGORITHM FOR THE RECEIVER
                        1.Create ServerSocket and Socket and accept the Client.
                        2.Get the Frame size from the sender and create a string Array of that size.
                        3.Inside while, Get the window size and using for loop print the Data.
                        4.Send the Acknowledgement for the printed Data to the sender.
*/
import java.io.*;
import java.net.*;
import java.util.*;


public class SW_Receiver{
    public static void main(String args[])throws Exception{

            ServerSocket Server = new ServerSocket(1000);
            Socket socket = Server.accept();

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            int frame = Integer.parseInt((String)input.readUTF());
            String Data[] = new String[frame];

            int i=0;
            while(i<frame){
                int window = Integer.parseInt((String)input.readUTF());
                int k=0;

                for(int j=0; j<window; j++){
                    Data[i] = (String)input.readUTF();
                    System.out.println("THE Data IN "+k+" FRAME : "+Data[i]);
                    i++;
                    k++;
                }
                System.out.println("ACKNOWLEDGEMENT SENT FOR "+window+" FRAMES.");
                output.writeUTF(Integer.toString(i));
            }
    }
}