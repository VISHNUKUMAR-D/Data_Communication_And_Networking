/*
                    ALGORITHM FOR SERVER
                    1.Creat ServerSocket and accept the client using the Socket 
                    2.Create object for DatainputStream and DataoutputStream
                    3.Read the input from the Client
                    4.Create the URL object and process the input from the Client
                    5.Using While loop read all the contents(code) in the webpage and store in a StringBuffer object
                    6.Convert the data in String Buffer to string and send as the output to the Client
                    7.Close all the Sockets
*/
import java.io.*;
import java.net.*;
import java.util.*;


public class Webpage_Server{
    public static void main(String args[]){
        try{
            ServerSocket Server_Socket = new ServerSocket(3000);
            Socket Socket = Server_Socket.accept();
            DataInputStream input = new DataInputStream(Socket.getInputStream());
            DataOutputStream output = new DataOutputStream(Socket.getOutputStream());

            String String = (String)input.readUTF();
            URL url = new URL(String);
            Scanner scan = new Scanner(url.openStream());

            StringBuffer S_Buffer = new StringBuffer();

            while(scan.hasNext()){
                S_Buffer.append(scan.next());
            }
            String data = S_Buffer.toString();
            data = data.replaceAll(">", ">\n");
            output.writeUTF(data);

            output.flush();
            output.close();
            input.close();
            scan.close();
            Socket.close();
            Server_Socket.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}