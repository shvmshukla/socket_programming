//package socket;
import java.io.*;
import java.net.*;
public class clientsort{
    public static void main(String[] args)  {
        try {
            Socket s = new Socket("localhost", 3336);
            System.out.println(" CONGRATS!  Client Server connection has been established \n");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String a[]= new String[5];
            String b[]= new String[5];            
                System.out.println("Enter the numbers in array");
                for(int i=0;i<5;i++)
                {
                  a[i] = br.readLine();
                } 
                for(int i=0;i<5;i++)
                {
                 dout.writeUTF(a[i]);
                }
                
               
                dout.flush();

                for(int i=0;i<5;i++)
                {
                 b[i] = din.readUTF(); 
                }
 
                
                System.out.println("server sends the sorted order as follows: " );
               for(int i=0;i<5;i++)
                {
                 System.out.println(b[i]); 
                }

            
            dout.close();
            s.close();
        }catch (Exception e)
        {
            System.out.println(e);
            System.out.println("SORRY ! connection has not established");
        }
    }
}

