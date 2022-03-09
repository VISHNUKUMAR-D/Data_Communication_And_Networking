import java.net.*;
import java.io.*;
import java.util.*;
public class Client{
    public static void main(String Args[]) throws Exception{
       Socket s = new Socket("localhost",3999);

       DataInputStream in = new DataInputStream(s.getInputStream());
       DataOutputStream out = new DataOutputStream(s.getOutputStream());

       System.out.print("ENTER THE FRAME SIZE : ");
       Scanner scan = new Scanner(System.in);
       String length = scan.nextLine();
        out.writeUTF(length);
       String Data[]=new String[Integer.parseInt(length)];

       for(int i=0; i<Integer.parseInt(length); i++){
           System.out.print("ENTER DATA "+(i+1)+" : ");
           Data[i] = scan.nextLine();
           out.writeUTF(Data[i]);
           System.out.println(in.readUTF());
       }
    }
    
}