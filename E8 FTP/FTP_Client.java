/*
        ALGORITHM FOR FTP_CLIENT:

        1.Create object for Socket and pass hostname and port number as arguement.
        2.Get the FileName from the user using scan.
        3.Create FileInputStream and BufferedInputStream object.
        4.Using the created objects read the contents of the given File and store in a Array.
        5.Now, write the content to the Server.
        6.Close all Socket, BufferedInputStream objects.
*/

import java.io.*;
import java.util.*;
import java.net.*;

public class FTP_Client{
    public static void main(String args[]) throws Exception{
            Socket s = new Socket("localhost", 4000);

            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            Scanner scan = new Scanner(System.in);

            System.out.print("ENTER THE FILE NAME : ");
            String Name = scan.next();

            File FileName = new File(Name);

            FileInputStream FIS = new FileInputStream(FileName);
            BufferedInputStream BIS = new BufferedInputStream(FIS);

            long Length = FileName.length();

            byte[] Content = new byte[(int)Length];
            BIS.read(Content, 0, (int)Length);
            output.write(Content);

            s.close();
            BIS.close();
            System.out.println("FILE SENT SUCCESSFULLY !");
    }
}
