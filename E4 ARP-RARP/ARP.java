import java.net.*;

public class ARP{
    public static void main(String[] args) throws Exception{
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);

            if(ni!=null){
                byte[] mac = ni.getHardwareAddress();
                if(mac!=null){
                    for(int i=0; i<mac.length; i++)
                        System.out.format("%02X%s", mac[i], ((i<mac.length-1)?"-":""));
                }
                else System.out.println("ADDRESS CANNOT BE ACCESSIBLE");
            }else System.out.println("NETWORK INTERFACE DOES NOT CONTAIN THE GIVEN ADDRESS");
    }
}