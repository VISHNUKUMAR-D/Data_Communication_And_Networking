/*
        ALGORITHM
        1.Get the IP Address.
        2.Spli the IP Address based on the '.' and store in a Array.
        3.Covert the value in the array to Binary and append in a single variable and print it.
        4.Get Subnet Mask.
        5.Print Host Portion and Number of Networks.
        6.Using for loop make some changes in the bits.
        7.Print the First Address and the Last Address.
*/
import java.util.Scanner;

public class Sub_Net{
    public static void main(String args[]){
    Scanner scan = new Scanner(System.in);
    System.out.print("ENTER IP ADDRESS : ");
    String ip = scan.nextLine();
    String[] split_ip = ip.split("\\.");
    String bip="", Last_Address, First_Address;

    for(int i=0; i<4; i++)
        bip += appendZeros(Integer.toBinaryString(Integer.parseInt(split_ip[i])));
    System.out.println("IP ADDRESS IN BINARY : "+bip);
    First_Address = Last_Address = bip;

    int mask, start, end, bits, over, power;
    System.out.print("ENTER THE SUBNET MASK :");
    mask = scan.nextInt();
    bits = 32-mask;

    if(mask>24){
        over = mask-24;
        power = over;
    }
    else if(mask>64){
        over = mask-16;
        power = over + 8;
    }
    else{
        over = mask-8;
        power = mask+8;
    }
    System.out.println("NUMBER OF NETWORKS : "+Math.pow(2, power));
    System.out.println("THE HOST PORTION : "+(Math.pow(2, (8-over))-2));

    for(int i=31; i>31-bits; i--)
        First_Address = First_Address.substring(0, i)+"0"+First_Address.substring(i+1);
    
    start=0; end=8;
    System.out.print("FIRST ADDRESS : ");
    for(int i=0; i<4; i++){
        System.out.print(Integer.parseInt(First_Address.substring(start, end), 2));
        if(i!=3)System.out.print(".");
        start=end; end+=8;
    }


    for(int i=31; i>31-bits; i--)
        Last_Address = Last_Address.substring(0, i)+"1"+Last_Address.substring(i+1);
    
    start=0; end=8;
    System.out.print("\nLAST ADDRESS : ");
    for(int i=0; i<4; i++){
        System.out.print(Integer.parseInt(Last_Address.substring(start, end), 2));
        if(i!=3)System.out.print(".");
        start=end; end+=8;
    }

    }
    public static String appendZeros(String s){
        String temp = "00000000";
        return temp.substring(s.length())+s;
    }

}