import java.io.*;
import java.net.*;
public class client{
    public static void main(String args[]){
        try{
            Socket s = new Socket("localhost", 4999);
            DataInputStream in = new DataInputStream(s.getInputStream());
            String str = (String)in.readUTF();
            System.out.println(str);
            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}