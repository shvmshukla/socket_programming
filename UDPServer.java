import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

class UDPServer 
{
   public static void main(String args[]) throws Exception
   {

      DatagramSocket serverSocket = 
         new DatagramSocket(9876);

      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];

      while(true)
      {
         DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket);
         String str = new String(receivePacket.getData(),0, receivePacket.getLength());

	 DatagramPacket receivePacket1 =new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket1);
         String str1 = new String(receivePacket1.getData(),0, receivePacket1.getLength());

	 DatagramPacket receivePacket2 =new DatagramPacket(receiveData, receiveData.length);
         serverSocket.receive(receivePacket2);
         String str2 = new String(receivePacket2.getData(),0, receivePacket2.getLength());

         InetAddress IPAddress = receivePacket.getAddress();
         int port = receivePacket.getPort();

	System.out.println(str);
	System.out.println(str1);
	System.out.println(str2);
	String r1="",r2="",str3="",str4="",str5="";

		r1 = fun(str ,str2 );
                r2 = fun(str1 , str2);

            if(r1.equals(r2))
                str3 = "Same Network";
            else
                str3 = "Different Network";

         sendData = str3.getBytes();

         DatagramPacket sendPacket =
            new DatagramPacket(sendData, sendData.length,
                               IPAddress, port);

         serverSocket.send(sendPacket);
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
