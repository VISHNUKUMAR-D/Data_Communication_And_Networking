/*
                            ALGORITHM FOR DNS
                            1.Create Scanner and Buffer Reader object to read the input from the user
                            2.Get the HostName from the user
                            3.Create InetAddress object and pass the HostName as arguement to the getbyName() method
                            4.Print the IP address for the given HostName using getHostAddress() method
*/
import java.net.*;
import java.util.*;

public class DNS{
    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int n;
        do{
            System.out.println("\nMENU:\n1.DNS\n2.EXIT");
            System.out.print("PLEASE, ENTER YOUR CHOICE : ");
            n = scan.nextInt(); 
            if(n==1)
            {
                    System.out.print("\nENTER HOST NAME : ");
                    String HostName = scan.next();
                    InetAddress address = InetAddress.getByName(HostName);
                    System.out.println("\nHOST NAME : " + address.getHostName());
                    System.out.println("IP : " + address.getHostAddress());
            }
        }while(!(n==2));
    }
}
