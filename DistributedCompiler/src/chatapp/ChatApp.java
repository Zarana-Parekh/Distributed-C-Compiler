package chatapp;

import javax.swing.JFrame;
/**
 *
 * @author zaranaparekh1
 */
public class ChatApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConnectWindow conWindow = new ConnectWindow();
        JFrame window = conWindow.getConnectWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        System.out.println("chat frame");
        Server server = new Server(3456, User.getUserName());
        server.start();
//        Client client = new Client(User.getUserName());
//        client.start();
    }
    
}
