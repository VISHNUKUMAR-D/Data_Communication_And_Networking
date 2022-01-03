import java.io.*;
import java.net.*;
public class server{
    public static void main(String args[]) throws Exception{
            ServerSocket ss = new ServerSocket(4999);
            Socket s = ss.accept();
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            String str = "SIMPLEX SOCKET PROGRAMMING";
            out.writeUTF(str);
            out.flush();
            out.close();
            s.close();
    }
}
