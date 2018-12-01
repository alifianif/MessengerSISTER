/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author
 * Alifiani Fauzia (1301140417)
 * Andreas Jonathan (1301140427)
 */
import java.io.*;
import java.net.Socket;

public class Client {
 
 private static Socket socket = null;
 
 public static void main(String[] args)
 {
    // The default port. port bebas, asal client & server portnya sama.
     int port = 13011;
     
     // The default host (ip server)
     String host = "192.168.43.233";

     if (args.length < 2) {
         System.out.println("=======================================================================");       
         System.out.println("*                       Menunggu koneksi                              *");
     } else {
       host = args[0];
       port = Integer.valueOf(args[1]).intValue();
     }
  try {
       socket = new Socket(host, port);
       KirimThread kirim = new KirimThread(socket);
       Thread thread = new Thread(kirim);
       thread.start();
       TerimaThread terima = new TerimaThread(socket);
       Thread thread2 = new Thread(terima);
       thread2.start();
      }
  catch (Exception e) {
      System.out.println(e.getMessage());
  }
 }
}
