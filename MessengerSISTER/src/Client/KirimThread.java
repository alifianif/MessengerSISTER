/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * 
 */
public class KirimThread implements Runnable {
 Socket socket=null;
 PrintWriter print=null;
 BufferedReader input=null;

//constructor
 public KirimThread(Socket sock)
 {
  this.socket = sock;
 }
 
 //method run
 public void run(){
  try{
  if(socket.isConnected())
  {
   System.out.println("=======================================================================");
   System.out.println("         Client tersambung dengan " + socket.getInetAddress() + " di port " + socket.getPort());
   System.out.println("=======================================================================");
   System.out.println("*           Ketikkan Pesan dengan kata 'exit' untuk keluar            *");
   System.out.println("=======================================================================");
   this.print = new PrintWriter(socket.getOutputStream(), true);
   while(true){
    System.out.println("Kirim Pesan Anda    : ");
    input = new BufferedReader(new InputStreamReader(System.in));
    String keServer=null;
    keServer = input.readLine();
    this.print.println(keServer);
    this.print.flush();
    if(keServer.equals("exit")){
        break;
    }
   }//end while
   socket.close();
  }
  }catch(Exception e){
      System.out.println(e.getMessage());
  }
 }
}
