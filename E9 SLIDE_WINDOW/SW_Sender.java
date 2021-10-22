/*
                        ALGORITHM FOR THE SENDER
                        1.Create Socket and pass hostname and port number as arguement.
                        2.Create DataInpuStream and DataOutputStream objects.
                        3.Get the size of window and the frame.
                        4.Create a string Array of frame size.
                        5.Send the Frame size to the Receiver.
                        6.Get the Data from the User.
                        7.Inside While loop, Send the Data to the Receiver limitted to the Window size using for loop.
                        8.Get the Acknowledgement from the Receiver and print it.
*/

import java.io.*;
import java.net.*;
import java.util.*;

public class SW_Sender{
    public static void main(String args[]){
        try{
            Socket socket = new Socket("localhost", 1000);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            Scanner scan = new Scanner(System.in);
            HashSet<Integer> Set = new HashSet<Integer>();


            System.out.print("ENTER THE WINDOW SIZE : ");
            int window = scan.nextInt();
            System.out.print("ENTER THE DATA FRAME SIZE : ");
            int frame = scan.nextInt();

            output.writeUTF(Integer.toString(frame));
            String data[] = new String[frame];

            System.out.println("ENTER "+frame+" DATA INTO THE FRAME : ");
            for(int i = 0 ; i<frame; i++){
                data[i] = scan.next();
            }
            int i = 0;
            while(i < frame){
                if(i+window >= frame){
                    System.out.println("SENDING "+(frame-i)+" FRAMES...");
                    output.writeUTF(Integer.toString(frame-i));
                    for(i = i; i<frame; i++){
                        output.writeUTF(data[i]);
                        Set.add(i);
                    }
                }
                else{
                    System.out.println("SENDING "+window+" FRAMES...");
                    output.writeUTF(Integer.toString(window));
                    for(int j = 0; j<window; j++){
                        output.writeUTF(data[i]);
                        Set.add(i);
                        i++;
                    }
                }
                int acknowledgement = Integer.parseInt((String)input.readUTF());
                System.out.println("ACKNOWLEDGEMENT RECEIVED FOR THE FRAMES : "+Set);
                Set.clear();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}