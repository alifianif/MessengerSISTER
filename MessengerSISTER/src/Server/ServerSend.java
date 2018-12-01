/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * 
 */
class ServerSend implements Runnable
{
 PrintWriter pwPrintWriter;
 Socket clientSock = null;

 public ServerSend(Socket clientSock)
 {
  this.clientSock = clientSock;
 }
 
 public void run() {
  try{
  pwPrintWriter = new PrintWriter(new OutputStreamWriter(this.clientSock.getOutputStream()));

  while(true)
  {
   String msgToClientString = null;
   BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

   msgToClientString = input.readLine();

   pwPrintWriter.println(msgToClientString);
   pwPrintWriter.flush();
   System.out.println("Kirim Pesan Anda : ");
   
  if(msgToClientString.equals("exit"))
  break;
  }
  clientSock.close();}catch(Exception ex){System.out.println(ex.getMessage());}
 }
}

