
package projectcse110;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class LoginFrame extends JFrame{
   private JLabel userLabel,passLabel;
   private JTextField tf;
   private JPasswordField pf;
   private JButton loginButton, clearButton;
   private Container c;
   private Font  f;

    public LoginFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200,150, 600, 450);
        this.setName("IT Company Management System");
        this.setTitle("IT Company Management Login System");
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.CYAN);
        f = new Font("Lato",Font.ITALIC,17);
        userLabel = new JLabel("Enter Username : ");
        userLabel.setBounds(120, 50, 150, 50);
        userLabel.setFont(f);
        c.add(userLabel);
        
        tf = new JTextField();
        tf.setBounds(280,50,200,50);
        tf.setFont(f);
        c.add(tf);
        
        passLabel = new JLabel("Enter Password : ");
        passLabel.setBounds(120, 120, 150, 50);
        passLabel.setFont(f);
        c.add(passLabel);
        
        pf = new JPasswordField();
        pf.setBounds(280,120,200,50);
        pf.setFont(f);
        pf.setEchoChar('*');
        c.add(pf); 
        
        loginButton = new JButton("Login");
        loginButton.setBounds(200, 210, 90, 50);
        loginButton.setFont(f);
        c.add(loginButton);
        
        clearButton = new JButton("Clear");
        clearButton.setBounds(320, 210, 90, 50);
        clearButton.setFont(f);
        c.add(clearButton);
        
        clearButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
              tf.setText("");
              pf.setText("");
            }
        });
        
        
        loginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = tf.getText();
                String password = pf.getText();
                if(username.equals("cse110") && password.equals("123") || username.equals("sanim") && password.equals("sanim")){
                
                JOptionPane.showMessageDialog(null, "Congratulation, Successfully login!");
                dispose();
                Dashboard d1 = new Dashboard();
                d1.setVisible(true);
                }
                else{
                JOptionPane.showMessageDialog(null, "Sorry,Invalid password.");
                
                }
            }
        });
        
        
        
        
        
    }
   
}
public class ITCompanyLogin {
    public static void main(String[] args) {
        LoginFrame f = new LoginFrame();
        f.setVisible(true);
    }
}
