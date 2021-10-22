/*
        ALGORITHM FOR FTP_SERVER:
        
        1.Create ServerSocket and Socket object and accept the client.
        2.Create a File to copy the content of the Client's File.
        3.Get the content of the Client's File using DataInputStream.
        4.Create object for FileOutputStream and BufferedOutputStream.
        5.Using the created object write the content into the created File.
        6.Close all created ServerSocket, Socket and BufferedOutputStream objects.
*/

import java.io.*;
import java.net.*;

public class FTP_Server{
    public static void main(String args[]){
        try{
            ServerSocket Server = new ServerSocket(4000);
            Socket socket = Server.accept();

            byte[] Content = new byte[10000];
            String FileName = "Copied_File.txt";

            DataInputStream input = new DataInputStream(socket.getInputStream());
            int size = input.read(Content);

            FileOutputStream FOS = new FileOutputStream(FileName);
            BufferedOutputStream BOS = new BufferedOutputStream(FOS);

            BOS.write(Content, 0, size);
            System.out.println("FILE SAVED SUCCESSFULLY !");

            Server.close();
            socket.close();
            BOS.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}