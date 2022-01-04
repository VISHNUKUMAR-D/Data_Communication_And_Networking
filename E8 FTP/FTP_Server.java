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
    public static void main(String args[]) throws Exception{
            ServerSocket ss = new ServerSocket(4000);
            Socket s = ss.accept();

            byte[] Content = new byte[10000];
            
            DataInputStream input = new DataInputStream(s.getInputStream());
            int size = input.read(Content);

            FileOutputStream FOS = new FileOutputStream("Copied_File.txt");
            BufferedOutputStream BOS = new BufferedOutputStream(FOS);

            BOS.write(Content, 0, size);
            System.out.println("FILE SAVED SUCCESSFULLY !");

            ss.close();
            s.close();
            BOS.close();
    }
}
