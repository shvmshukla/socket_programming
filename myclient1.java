import java.io.*;
import java.net.*;
public class myclient1{
    public static void main(String[] args)  {
        try {
            Socket s = new Socket("localhost", 3336);
            System.out.println(" CONGRATS!  Client Server connection has been established \n");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "", str2 = "", str1 = "", str3 = "";
            while (!str.equals("stop")) {
                System.out.println("Enter the first IP Address");
                str = br.readLine();
                System.out.println("Enter the second IP Address");
                str1 = br.readLine();
                System.out.println("Enter the subnet mask");
                str2 = br.readLine();
                dout.writeUTF(str);
                dout.writeUTF(str1);
                dout.writeUTF(str2);
                dout.flush();
                str3 = din.readUTF();
                System.out.println("server says: " + str3);
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

