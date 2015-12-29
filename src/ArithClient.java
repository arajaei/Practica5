import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ArithClient {
  public static void main(String[] args) throws Exception {

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
    Socket theSocket = new Socket(hostname, Port);
    
    System.out.println("Connected to echo server");  
    
      int z1[] = new int[10]={1,2,3,4,5,6,7,8,9,10};
      int z2[] = new int[10]={1,2,3,4,5,6,7,8,9,10};
      int result[] = new int[10]={0,0,0,0,0,0,0,0,0,0};
      DataObj x = new DataObj();
      DataObj y = new DataObj();
      DataObj w = new DataObj();
      x.set(z1);
      y.set(z2);
    	ObjectOutput is = new ObjectOutputStream(new FileOutputStream("datos.out"));
	    is.writeObject(x);
      is.flush();
      is.close();
//-------------------- segundo DataObj-----------------------

	OutputStream o2 = new FileOutputStream("datos.out");
	ObjectOutput s2 = new ObjectOutputStream(o2);
	s2.writeObject(y);
  s2.flush();
  s2.close();

//------------------Esperara a resultado-----------------------

        InputStream o = new FileInputStream("datos.in");
        ObjectInput s1 = new ObjectInputStream(o);
        w = (DataObj) s1.readObject();
        s1.close();
        w.show();
        System.out.println("");

    while (true) {
      String theLine = userIn.readLine();
      if (theLine.equals("."))
        break;
      out.println(theLine);
      out.flush();
      System.out.println(networkIn.readLine());
    }


    //BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
   // PrintWriter out = new PrintWriter(theSocket.getOutputStream());
 
    networkIn.close();
    out.close();
  }
}
