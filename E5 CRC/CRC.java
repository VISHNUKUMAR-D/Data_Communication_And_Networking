/*
        Algorithm for CRC
        1.Get the Data word from the user.
        2.Get the generator polynomial from the user.
        3.Concatenate the data word with (length of generator polynomial-1) zeros.
        4.Do XOR operation on modified code and the generator polynomial.
        5.Return the remainder and concatenate the code with the remainder.
        6.Enter the received code and Repeat step 4 again and return remiander.
        7.If the remainder is 1 then the Received code has an error.
        8.If the remainder is 0 then the Received code has no error.
*/

import java.util.*;

 public class CRC{
     private static String Data_word="";
     private static String Generator="";
     private static String k="";
     private static String code="";
     private static String data="";
     private static String remainder = "";

     public static void main(String args[]){
         
         Scanner scan = new Scanner(System.in);
         System.out.print("\nENTER THE BINARY DATA WORD : ");
         Data_word = scan.nextLine();
         System.out.print("ENTER THE GENERATOR POLYNOMIAL : ");
         Generator = scan.nextLine();
         for(int i=0; i<Generator.length()-1; i++){
            k += "0";
         }
         data = Data_word + k;
         System.out.println("\nMODIFIED DATA_WORD "+(Generator.length()-1)+" ZEROS : "+data);
         code = div(data, Generator);

         data = Data_word + code;
         System.out.println("ENCODED DATA THAT IS SENT TO THE RECEIVER :"+data);

         System.out.print("\nENTER THE ENCODED DATA THAT IS RECEIVED : ");
         data = scan.nextLine();
         code = div(data, Generator);
         if(Integer.parseInt(code) != 0)
             System.out.println("THE RECEIVED CODE HAS AN ERROR");
         else
             System.out.println("THE RECEIVED CODE HAS NO ERROR");

     }

     public static String div(String data, String Generator){
        int length = Generator.length();
        String one_zero = "01";
        code = data.substring(0, Generator.length());

        while(length < data.length()){
            if(code.charAt(0) == one_zero.charAt(0)){
                code = code.substring(1, code.length());
                code += data.charAt(length++);
            }
            process_XOR();    
        }
        return (code = code.substring(1, code.length()));
    }

    public static void process_XOR(){
        for(int i=0; i<Generator.length(); i++){
            if(code.charAt(i) == Generator.charAt(i))
                remainder += "0";                 
            else
                remainder += "1";
        }
        code = remainder;
        remainder = "";
    }
}
 
