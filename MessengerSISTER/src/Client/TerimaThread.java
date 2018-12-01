/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * 
 */
public class TerimaThread implements Runnable {
 Socket socket=null;
 BufferedReader terima=null;

 //constructor
 public TerimaThread(Socket sock) {
  this.socket = sock;
 }
 
 //method run
 public void run() {
  try{
    terima = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));//get inputstream
    String terimapesan = null;
    while((terimapesan = terima.readLine()) != null)
    {
        System.out.println("Pesan Dari Server   : " + terimapesan);
        System.out.println("Kirim Pesan Anda    : ");
    }// end while
  }catch(Exception e){
      System.out.println(e.getMessage());
  }
 }
}

