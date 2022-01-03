import java.io.*;
import java.net.*;
public class client{
    public static void main(String args[]) throws Exception{
            Socket s = new Socket("localhost", 4999);
            DataInputStream in = new DataInputStream(s.getInputStream());
            String str = (String)in.readUTF();
            System.out.println(str);
            s.close();
    }
}
