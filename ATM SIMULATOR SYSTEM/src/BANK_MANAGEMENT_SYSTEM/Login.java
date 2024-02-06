package BANK_MANAGEMENT_SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
     JButton login;
     JButton signup;
     JButton clear;
     JTextField cardTextField;
     JPasswordField pinTextField;
    Login(){
        setTitle("ATM MACHINE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text  = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,28));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno  = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arail",Font.BOLD,14));
        add(cardTextField);

        JLabel pin  = new JLabel("PIN:");
        pin.setFont(new Font("Onwarrd",Font.BOLD,30));
        pin.setBounds(120,220,400,30);
        add(pin);

         pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arail",Font.BOLD,14));
        add(pinTextField);

         login  =new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

         clear  =new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

         signup  =new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);





        getContentPane().setBackground(Color.white);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public static void main(String[] args) {

        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear){
           cardTextField.setText("");
          // cardTextField.setText("");
        }
        else if(e.getSource() == login){

            DatabaseConnection conn  = new DatabaseConnection();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();

            String query = "select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+ pinnumber+"'";
           try{
              ResultSet rs= conn.s.executeQuery(query);

              if(rs.next()){
                  setVisible(false);
                  new Transactions(pinnumber).setVisible(true);
              }
              else{
                  JOptionPane.showMessageDialog(null,"Incorrect card number or pin");
              }
           }
           catch(Exception ae){
               System.out.println(ae);
               ae.printStackTrace();
           }


        }
        else if(e.getSource() == signup){
              setVisible(false);
              new SignUpOne().setVisible(true);
        }
    }
}
