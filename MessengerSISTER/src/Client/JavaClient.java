/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author USER
 */
import java.util.*;
import org.apache.xmlrpc.*;


public class JavaClient {
   public static void main (String [] args) {
   
      try {
         XmlRpcClient server = new XmlRpcClient("http://10.20.1.90:8888/RPC2"); 
         Vector params = new Vector();
         
         params.addElement(new Integer(17));
         params.addElement(new Integer(13));

         Object result = server.execute("sample.sum", params);
         Object result1 = server.execute("sample.sub", params);
         Object result2 = server.execute("sample.times", params);
         Object result3 = server.execute("sample.divide", params);

         int sum = ((Integer) result).intValue();
         int sub = ((Integer) result1).intValue();
         int times = ((Integer) result2).intValue();
         int divide = ((Integer) result3).intValue();

         System.out.println("Hasil pertambahan adalah: "+ sum);
         System.out.println("Hasil pengurangan adalah: "+ sub);
         System.out.println("Hasil perkalian adalah: "+ times);
         System.out.println("Hasil pembagian adalah: "+ divide);

      } catch (Exception exception) {
         System.err.println("JavaClient: " + exception);
      }
   }
}

