import java.io.*;
import java.net.*;

class UDPClientSort
{
   public static void main(String args[]) throws Exception
   {
      		
      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
      DatagramSocket clientSocket = new DatagramSocket();
      InetAddress IPAddress = InetAddress.getByName("localhost");
      byte[] sendData;
      byte[] receiveData = new byte[1024];

     // String sentence = inFromUser.readLine();


		String a[]= new String[5];
                System.out.println("Enter the numbers in array");
                for(int i=0;i<5;i++)
                {
                  a[i] = inFromUser.readLine();
                } 
                for(int i=0;i<5;i++)
                {
                 sendData = a[i].getBytes();
      		 DatagramPacket sendPacket =new DatagramPacket(sendData,sendData.length,IPAddress,9876);
      		 clientSocket.send(sendPacket);
                }

     		System.out.println("FROM SERVER: ");
		DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
		clientSocket.receive(receivePacket);
		String str = new String(receivePacket.getData(),0,receivePacket.getLength());
		System.out.println(str);

      clientSocket.close();
   }
}

