import java.io.*;
import java.net.*;
import java.util.Arrays;

class UDPServerSort 
{
   public static void main(String args[]) throws Exception
   {

      DatagramSocket serverSocket =new DatagramSocket(9876);
      byte[] receiveData = new byte[1024];
      byte[] sendData = new byte[1024];

	int a[]= new int[5];
	String b[]= new String[5];
	int i=0;
	InetAddress IPAddress=InetAddress.getByName("127.0.0.1");;
        String str = "",s="";
	int port = 3425;		

	for(i=0;i<5;i++){
		DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length);
         	serverSocket.receive(receivePacket);
         	str = new String(receivePacket.getData(),0,receivePacket.getLength());
		a[i] = Integer.parseInt(str);
		
		IPAddress = receivePacket.getAddress();
		port = receivePacket.getPort();
	  }	
	

	 for(i=0;i<5;i++){
		System.out.println(a[i]);
	  }

	Arrays.sort(a);	
	for(i=0;i<5;i++){
		b[i]=Integer.toString(a[i]);
		System.out.println(b[i]);
	  }

	for(i=0;i<5;i++){
      		 s=s+b[i]+"  ";
                }
	sendData = s.getBytes();
	DatagramPacket sendPacket =new DatagramPacket(sendData, sendData.length, IPAddress, port);
        serverSocket.send(sendPacket);
	System.out.println(s);
      }
}
