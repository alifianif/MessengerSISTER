/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 * 
 * @author
 * Alifiani Fauzia (1301140417)
 * Andreas Jonathan (1301140427)
 */

    
import java.io.*;
import java.net.*;
import java.lang.*;

public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

  final int port = 13011;
  System.out.println("==================================================");
  System.out.println("             Messenger Java tanpa GUI             ");
  System.out.println("==================================================");
  System.out.println("         SISTEM PARALEL DAN TERDISTRIBUSI         ");
  System.out.println("           Alifiani Fauzia (1301140417)           ");
  System.out.println("          Andreas Jonathan (1301140427)           ");
  System.out.println("==================================================");
  System.out.println("              Ketik 'exit' untuk keluar           ");
  System.out.println("==================================================");
  System.out.println("      Server Menunggu Koneksi Port = "+port        );
  System.out.println("==================================================");


  ServerSocket SS = new ServerSocket(port);
  Socket csocket = SS.accept();
  System.out.println("Server Menerima Koneksi Dari "+csocket.getInetAddress()+" di port "+csocket.getPort());
  ServerReceive receive = new ServerReceive(csocket);
  Thread thread = new Thread(receive);
  thread.start();
  ServerSend send = new ServerSend(csocket);
  Thread thread2 = new Thread(send);
  thread2.start(); 
  }
}