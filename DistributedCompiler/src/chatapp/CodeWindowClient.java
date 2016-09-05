/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author zaranaparekh1
 */
public class CodeWindowClient extends javax.swing.JFrame {

    private String userName;
    private final Socket socket;
    private DataOutputStream dos = null;
    private InputStream iS;
    private DataInputStream dIStream;
    private Client client;
 //   private BufferedReader incoming;
 //   String fcName;
    
    /**
     * Creates new form CodeWindow
     */
    public CodeWindowClient(String userName, Socket socket,Client client) {
        this.userName = userName;
        this.socket = socket;
        this.client=client;
        try {
            this.dos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(CodeWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }

    public JFrame getCodeWindow(String userName, Socket socket) {
        return this;
    }
    
    public void readMessage()throws IOException
    {
    	iS = socket.getInputStream();
        dIStream = new DataInputStream(iS);
 //       incoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 //       fcName = incoming.readLine();
     
    	
    }
    public void writeMessage(String receivedMessage) {
        this.chatPane.append(receivedMessage);
    }
    private void sendMessage(String sentMessage) {
        try {
            if ((sentMessage != null || !"\n".equals(sentMessage)) && !socket.isClosed()) {
                dos.writeUTF(sentMessage);
                System.out.println("sentmessage : "+sentMessage);
            }
        } catch (IOException ex) {
            Logger.getLogger(CodeWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatPane = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageArea = new javax.swing.JTextArea();
        Send = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chatPane.setColumns(20);
        chatPane.setRows(5);
        jScrollPane1.setViewportView(chatPane);

        messageArea.setColumns(20);
        messageArea.setRows(5);
        messageArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                messageAreaMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(messageArea);

        Send.setText("Send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });
        Send.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SendKeyPressed(evt);
            }
        });
        
        JButton browseButton = new JButton("Browse");
        browseButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        	}
        });
        browseButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		JFileChooser chooser = new JFileChooser();
        		
        	}
        });
        
        JTextArea browseTextArea = new JTextArea();
        browseTextArea.setBackground(Color.WHITE);
        
        btnCompile = new JButton("Compile");
        btnCompile.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(23)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(browseTextArea, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(Send)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btnCompile))))
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(20, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(323, Short.MAX_VALUE)
        			.addComponent(browseButton)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(14)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap(23, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(browseButton)
        						.addComponent(browseTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(20)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(Send)
        						.addComponent(btnCompile))
        					.addGap(38))))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

    private void messageAreaMouseEntered(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
        
    }                                        

    private void SendKeyPressed(java.awt.event.KeyEvent evt) {                                
        // TODO add your handling code here:
        String message = messageArea.getText();
        chatPane.append(User.getUserName() + " : " + message + "\n");
        messageArea.setText("");
        client.sendMessage(message);
        
    }                               

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CodeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CodeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CodeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CodeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CodeWindow(null,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Send;
    private javax.swing.JTextArea chatPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageArea;
    private JButton btnCompile;
}
