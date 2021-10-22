import java.io.*;
import java.util.Scanner;
import java.net.*;

public class h_client{
    public static void main(String args[])
    {
        try{
            Socket s = new Socket("localhost", 4999);
            Scanner scan = new Scanner(System.in);
            while(true){
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                DataInputStream din = new DataInputStream(s.getInputStream());
                System.out.print("Give a mes to SERVER : ");
                String str = scan.nextLine();
                out.writeUTF(str);
                if(str.equals("END"))
                    break;
                String mes = (String)din.readUTF();
                System.out.println("Mes from SERVER : " + mes);
                if(mes.equals("END"))
                    break;
            }
            s.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}