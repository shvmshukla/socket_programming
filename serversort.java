//package socket;
//import com.sun.corba.se.spi.activation.Server;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class serversort{
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(3336);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
	    int a[]= new int[5];
	    int i=0;
            String str = "", str1 = "", str2 = "", str3 = "", r1="" , r2= "";
            
		for(i=0;i<5;i++){
		str = din.readUTF();
		a[i] = Integer.parseInt(str);
	  }

	  for(i=0;i<5;i++){
		System.out.println(a[i]);
	  }
          Arrays.sort(a);
	  for(i=0;i<5;i++){
		System.out.println(a[i]);
	  }
     for(i=0;i<5;i++)
      {
        dout.writeUTF(a[i]+"");
      }
                dout.flush();
          s.close();
            ss.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

