import java.io.*;
import java.util.Scanner;
import java.net.*;

public class h_server{
    public static void main(String args[]){
        try{
            ServerSocket ss = new ServerSocket(4999);
            Scanner scan = new Scanner(System.in);
            Socket s = ss.accept();
            while(true){
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                String mes = (String)din.readUTF();
                System.out.print("Mes from CLIENT : " + mes);
                if(mes.equals("END"))
                    break;
                System.out.print("Give a mes to CLIENT : ");
                String str = scan.nextLine();
                out.writeUTF(str);
                if(str.equals("END"))
                    break;
            }
            ss.close();
            s.close();
        }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }