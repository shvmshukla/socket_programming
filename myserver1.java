
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class myserver1{
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(3336);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            String str = "", str1 = "", str2 = "", str3 = "", r1="" , r2= "";
            while (!str.equals("stop")) {
                str = din.readUTF();
                System.out.println("client's first IP : " + str);
                str1 = din.readUTF();
                System.out.println("client's second IP : " + str1);
                str2 = din.readUTF();
                System.out.println("client's subnet mask : " + str2);
                System.out.println("Data has received");

                //function which calculates whether both ip are in
                // same network or in different network

               r1 = fun(str ,str2 );
               r2 = fun(str1 , str2);

            if(r1.equals(r2))
                str3 = "Same Network";
            else
                str3 = "Different Network";

                dout.writeUTF(str3);
                dout.flush();
            }

            s.close();
            ss.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
    static String fun (String str4 , String str5)
    {
        String ip = str4;
        String mask = str5;
        String networkAddr = "";

        String ipParts[] = new String[4];
        String maskParts[] = new String[4];

        StringTokenizer str = new StringTokenizer(ip, ".");
        StringTokenizer strmass = new StringTokenizer(mask, ".");

        int i = 0;
        while (str.hasMoreTokens()) {
            ipParts[i] = str.nextToken();
            maskParts[i] = strmass.nextToken();
            i++;
        }
        for (int j = 0; j < 4; j++) {
            int x = Integer.parseInt(ipParts[j]);
            int y = Integer.parseInt(maskParts[j]);
            int z = x & y;
            networkAddr += z + ".";
        }
System.out.println(networkAddr);
        return networkAddr;
    }

}

