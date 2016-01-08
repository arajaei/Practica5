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
  
      int z1[]={1,1,1,1,1,1,1,1,1,1};
      int z2[]={2,2,2,2,2,2,2,2,2,2};
      
     try {
       
     
      DataObj x = new DataObj();
      DataObj y = new DataObj();
      DataObj w = new DataObj();

      x.set(z1);
      y.set(z2);
      System.out.println(" ");
      x.show();
      System.out.println(" ");
      y.show();
      long start;
      long end;

       start=System.currentTimeMillis();
//------------------- primer objecto ----------------------  
    	ObjectOutput is = new ObjectOutputStream(theSocket.getOutputStream());
	    is.writeObject(x);
	    is.flush();
        
//-------------------- segundo DataObj-----------------------

	    is.writeObject(y);
        is.flush();

//------------Esperara a resultado-----------------------

        ObjectInput s1 = new ObjectInputStream(theSocket.getInputStream());
        w = (DataObj) s1.readObject();
  
  end= System.currentTimeMillis();
  
        System.out.println(" ");
        w.show();
        
        System.out.println("\n Cronometro :"+( end-start));

        s1.close();
        is.close();
        theSocket.close();

     }//try
 catch(Exception e) {
         e.printStackTrace();
        System.out.println(e.getMessage());
     }
       
     }//main
}//class
