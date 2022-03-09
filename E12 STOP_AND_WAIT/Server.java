import java.net.*;
import java.io.*;
public class Server{
    public static void main(String Args[]) throws Exception{
        ServerSocket ss = new ServerSocket(3999);
        Socket s = ss.accept();

        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());

        int length = Integer.parseInt(in.readUTF());
        String Data[] = new String[length];

        for(int i=0; i<length; i++){
            Data[i] = in.readUTF();
            System.out.println("DATA RECEIVED IN "+(i+1)+" FRAME :"+Data[i]);
            out.writeUTF("DATA RECEIVED FOR "+(1+i)+" FRAME");
            System.out.println("ACKNOWLEDGEMENT SENT!");
        }
        s.close();
    }
}