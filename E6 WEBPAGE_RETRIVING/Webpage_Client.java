
/*
                    ALGORITHM FOR CLIENT
                    1.Creat Socket and pass hostname and port number as arguement 
                    2.Create object for DatainputStream and DataoutputStream
                    3.Get the input from the user using Scanner
                    4.Send it to the Server
                    5.Get the input from the server and print it in the console
                    6.Close the Socket
*/
import java.io.*;
import java.net.*;
import java.util.*;

public class Webpage_Client{
    public static void main(String args[]) throws Exception{
            Socket s = new Socket("localhost", 3000);
            DataInputStream input = new DataInputStream(s.getInputStream());
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            Scanner scan = new Scanner(System.in);

            System.out.print("ENTER THE URL OF A WEB-PAGE : ");
            String url = scan.nextLine();
            output.writeUTF(url);
            String code = input.readUTF();
            System.out.println("THE GIVEN URL HAS THE FOLLOWING HTML CODE : \n"+code);
            s.close();
    }
}
