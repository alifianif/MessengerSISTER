/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * 
 */
class ServerReceive implements Runnable
{
 Socket csocket = null;
 BufferedReader brBufferedReader = null;

 public ServerReceive(Socket csocket)
 {
  this.csocket = csocket;
 }
 
 public void run() {
  try{
  brBufferedReader = new BufferedReader(new InputStreamReader(this.csocket.getInputStream()));

  String messageString;
  while(true){
  while((messageString = brBufferedReader.readLine())!= null){
   if(messageString.equals("EXIT"))
   {
    break;
   }   
   System.out.println("Pesan Client     : " + messageString);
   System.out.println("Kirim Pesan Anda : ");
  }
  this.csocket.close();
  System.exit(0);
 }

 }
 catch(Exception ex){System.out.println(ex.getMessage());}
 }
}

