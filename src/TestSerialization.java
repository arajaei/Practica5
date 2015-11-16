import java.io.*;
import java.util.*;

public class TestSerialization {
    public static final int MAX_SIZE = 10;
    public static void main(String args[]) {

      DataObj x = null;
      DataObj y = null;
      int z1[] = new int[MAX_SIZE];
      int z2[] = new int[MAX_SIZE];
      int result[] = new int[MAX_SIZE];
	   
      try {

        int v[] = {1,2,3,4,5,6,7,8,9,10};
	ObjectOutput is = new ObjectOutputStream(new FileOutputStream("datos.in"));
	DataObj wmo = new DataObj();
        wmo.set(v);
	is.writeObject(wmo);
        is.flush();
        is.close();

        InputStream o = new FileInputStream("datos.in");
        ObjectInput s1 = new ObjectInputStream(o);
        x = (DataObj) s1.readObject();
        s1.close();
        x.show();
        System.out.println("");

        o = new FileInputStream("datos.in");
        s1 = new ObjectInputStream(o);
        y = (DataObj) s1.readObject();
        s1.close();
        y.show();
        System.out.println("");

	z1 = x.get();
	z2 = y.get();

        /* Suma de los arrays */
	for(int p=0; p<z1.length; p++) {
	   result[p] = z1[p] + z2[p];
	}

	OutputStream o2 = new FileOutputStream("datos.out");
	ObjectOutput s2 = new ObjectOutputStream(o2);
      
	DataObj myM = new DataObj();
        myM.set(result);
	s2.writeObject(myM);
        myM.show();
        System.out.println("");
        s2.flush();
        s2.close();

      } catch (Exception e) {
	  e.printStackTrace();
          System.out.println(e.getMessage());
      }
   }
}
