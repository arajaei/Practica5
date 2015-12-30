import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.lang.*;
import java.io.*;
import java.util.*;

public class ArithClient {
  public static void main(String[] args) throws Exception {

    Socket theSocket=null;
    int Port=8187;
    String hostname = "localhost";
    if(args.length ==2)
        {
          Port = Integer.parseInt(args[0]);
          hostname=args[1];
        }
    
    if(args.length != 0 && args.length != 2)
        {
          System.out.println("You must enter 2 or enter without arguments !!!!!");
        }
   //--------------------------------------------------------- 
    try{
   
    theSocket = new Socket(hostname, Port);
    System.out.println("Connected to echo server");  
    } catch (Exception e) {
	     
          System.out.println("Can't connect to server");
      }
  
      int z1[]={10,10,10,10,10,10,10,10,10,10};
      int z2[]={20,20,20,20,20,20,20,20,20,20};
      
     try {
       
     
      DataObj x = new DataObj();
      DataObj y = new DataObj();
      DataObj w = new DataObj();

      x.set(z1);
      y.set(z2);

      long start;
      long end;
//------------------- primer objecto ----------------------  
    	ObjectOutput is = new ObjectOutputStream(new FileOutputStream("datos.in"));
	    is.writeObject(x);
	    is.flush();
      is.close();
//-------------------- segundo DataObj-----------------------

	OutputStream o2 = new FileOutputStream("datos.in");
	ObjectOutput s2 = new ObjectOutputStream(o2);
	s2.writeObject(y);
  s2.flush();
  s2.close();

  start=System.currentTimeMillis();
//------------------Esperara a resultado-----------------------

        InputStream o = new FileInputStream("datos.out");
        ObjectInput s1 = new ObjectInputStream(o);
        w = (DataObj) s1.readObject();
  
  end= System.currentTimeMillis();
  
        s1.close();
        w.show();
        
        System.out.println("Cronometro :"+( end-start));
       theSocket.close();
     }//try
 catch(Exception e) {
         e.printStackTrace();
        System.out.println(e.getMessage());
     }
       
     }//main
}//class
