import java.io.*;
import java.net.*;

class UDPClient 
{
   public static void main(String args[]) throws Exception
   {
      		
      BufferedReader inFromUser =
         new BufferedReader(
         new InputStreamReader(System.in));

      DatagramSocket clientSocket = new DatagramSocket();

      // Replace hostname with the FQDN of the server.

		

      InetAddress IPAddress = InetAddress.getByName("localhost");

      byte[] sendData;

      byte[] receiveData = new byte[1024];

     // String sentence = inFromUser.readLine();

		System.out.println("Enter the first IP Address");
                String str = inFromUser.readLine();
                System.out.println("Enter the second IP Address");
                String str1 = inFromUser.readLine();
                System.out.println("Enter the subnet mask");
                String str2 = inFromUser.readLine();

		

      sendData = str.getBytes();
      DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length,IPAddress, 9876);
      clientSocket.send(sendPacket);

      sendData = str1.getBytes();
      DatagramPacket sendPacket1 =new DatagramPacket(sendData, sendData.length,IPAddress, 9876);
      clientSocket.send(sendPacket1);

      sendData = str2.getBytes();
      DatagramPacket sendPacket2 =new DatagramPacket(sendData, sendData.length,IPAddress, 9876);
      clientSocket.send(sendPacket2);



      DatagramPacket receivePacket =
         new DatagramPacket(receiveData, receiveData.length);

      clientSocket.receive(receivePacket);

      String modifiedSentence = new String(receivePacket.getData(),
                                           0, receivePacket.getLength());

      System.out.println("FROM SERVER: " + modifiedSentence);

      clientSocket.close();
   }

	       

}

