import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;

public class ArithServer {

   

    public static void main(String[] args) throws IOException{
       
        int PORT = 8187;
        
        if(args.length ==1)
         {
              PORT= Integer.parseInt(args[0]);
          }
        if(args.length != 0 && args.length != 1)
         {
             System.out.println("You can use this function only with 0 or 1 orguments !!!!");
             
         }
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        }
        catch (IOException e) {
            System.err.println("Could not listen on port: " + PORT);
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("coneccion esta aceptada en el puerta numero  :"+ PORT); 
        }
        catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
//---------------------------------------------------------
      
      
      DataObj x =new DataObj();
      DataObj y =new DataObj();
      int z1[] = new int[10];
      int z2[] = new int[10];
      int result[] = new int[10];
	   
      try {

        
        ObjectInput s1 = new ObjectInputStream(clientSocket.getInputStream());
        x = (DataObj) s1.readObject();
    
        
    
        System.out.println("\n first object X");
        x.show();
       

       
        y = (DataObj) s1.readObject();
    
        
        System.out.println("\n Secound object  Y");
        y.show();
        

	z1 = x.get();
	z2 = y.get();
//----------------------------------------------------------------------------
        /* Suma de los arrays */
	for(int p=0; p<z1.length; p++) {
	   result[p] = z1[p] + z2[p];
	}
//----------------------------------------------------------------------------
	
        ObjectOutput is = new ObjectOutputStream(clientSocket.getOutputStream());  
	    DataObj myM = new DataObj();
        myM.set(result);
	    is.writeObject(myM);
        is.flush();

        System.out.println("\n Resoults :");
        myM.show();
        System.out.println("");

        is.close();
        s1.close();
    
      } catch (Exception e) {
	  e.printStackTrace();
          System.out.println(e.getMessage());
      }

        clientSocket.close();
        serverSocket.close();
    }
}
