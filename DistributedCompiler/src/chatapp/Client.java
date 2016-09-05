/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

/**
 *
 * @author zaranaparekh1
 */
public class Client extends Thread {
 
      final static  String    serverIPname = "192.168.1.101";     // server IP name
      final static  int       serverPort   = 3456;                      // server port number
      java.net.Socket         sock = null;                              // Socket object for communicating
      java.io.PrintWriter     pw   = null;                              // socket output to server
      java.io.BufferedReader  br   = null;    // socket input from server
      String userName;
      public Client(String userName)
      {
    	  this.userName=userName;
      }
      public void sendMessage(String message)
      {
    	  pw.println(message);
      }
      
      public void run(){
 
      try {
            sock = new java.net.Socket(serverIPname,serverPort);       // create socket and connect
            pw   = new java.io.PrintWriter(sock.getOutputStream(), true);  // create reader and writer
            br   = new java.io.BufferedReader(new java.io.InputStreamReader(sock.getInputStream()));
            System.out.println("Connected to Server");
            CodeWindowClient codewindow=new CodeWindowClient(userName, sock, this);
//            pw.println("Message from the client");                      // send msg to the server
//            System.out.println("Sent message to server");
            String str;
            while(true)
            {
                if((str=br.readLine())!=null)
            	    codewindow.writeMessage(str);                           // get data from the server
                if(sock.isClosed())
                	break;
            }
            pw.close();                                                 // close everything
            br.close();
            sock.close();
      } catch (Throwable e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
      }
}
}