/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

/**
 *
 * @author zaranaparekh1
 */
public class Server extends Thread {
 
      private int   serverPort;                      // server port number
      private ServerSocket   sock = null;                              // original server socket
      private Socket         clientSocket = null;                      // socket created by accept
      private PrintWriter     pw   = null;                              // socket output stream
      private BufferedReader  br   = null;   // socket input stream
      private String userName;
      public Server(int serverPort,String userName)
      {
    	  this.serverPort=serverPort;
    	  this.userName=userName;
    	  
      }
      public void sendMessage(String message)
      {
    	  pw.println(message);
      }
      public void recievemessage() throws IOException
      {
    	  String msg=br.readLine();
          System.out.println("Message from the client >" + msg);
      }
      public void run()
      {
    	  User.setUserName(userName);
    	  try {
    		  	sock = new ServerSocket(serverPort);               // create socket and bind to port
                System.out.println("waiting for client to connect");
                clientSocket = sock.accept();                               // wait for client to connect
                System.out.println("client has connected");
                pw   = new java.io.PrintWriter(clientSocket.getOutputStream(),true);
                br   = new java.io.BufferedReader(new java.io.InputStreamReader(clientSocket.getInputStream()));
                CodeWindow codeWindow = new CodeWindow(userName,clientSocket,this);
                JFrame window = codeWindow.getCodeWindow(User.getUserName(),clientSocket);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setVisible(true);
                String str;
                while(true)
                {
                	if((str=br.readLine())!=null)
                		codeWindow.writeMessage(str);
                	if(clientSocket.isClosed())
                		break;
                }
//                String msg = br.readLine();                                 // read msg from client
 //               System.out.println("Message from the client >" + msg);
//                pw.println("Got it!");                                      // send msg to client
 
            pw.close();                                                 // close everything
            br.close();
            clientSocket.close();
            sock.close();
    	  } catch (Throwable e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
    	  }
      }
}