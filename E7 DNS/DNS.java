/*
                            ALGORITHM FOR DNS
                            1.Create Scanner and Buffer Reader object to read the input from the user
                            2.Get the HostName from the user
                            3.Create InetAddress object and pass the HostName as arguement to the getbyName() method
                            4.Print the IP address for the given HostName using getHostAddress() method
*/
import java.net.*;
import java.io.*;
import java.util.*;

public class DNS{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int n;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("\nMENU:\n1.DNS\n2.EXIT");
            System.out.print("PLEASE, ENTER YOUR CHOICE : ");
            n = scan.nextInt(); 
            if(n==1)
            {
                try {
                    System.out.print("\nENTER HOST NAME : ");
                    String Host_Name = input.readLine();
                    InetAddress address = InetAddress.getByName(Host_Name);
                    System.out.println("\nHOST NAME : " + address.getHostName());
                    System.out.println("IP : " + address.getHostAddress());
                } 
                catch(IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }while(!(n==2));
    }
}