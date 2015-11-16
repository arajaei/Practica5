import java.io.*;
import java.util.*;

public class DataObj implements Serializable {
   private int x[] = null;

   public int[] set(int msg[]){
      x = msg;
      return x;
   }

   public int[] get() {
      return x;
   }

   public void show() {
     for(int i=0; i<x.length; i++){
       System.out.print(x[i] + " ");
     }
   }
}
