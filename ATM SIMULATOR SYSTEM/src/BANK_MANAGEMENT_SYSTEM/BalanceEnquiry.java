package BANK_MANAGEMENT_SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry  extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;
     BalanceEnquiry(String pinnumber){

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image =new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);



          back = new JButton("BACK");
          back.setBounds(355,520,150,30);
          image.add(back);
          back.addActionListener(this);
         DatabaseConnection conn = new DatabaseConnection();
         int balance =0;
          try{

              ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+ pinnumber+"'");


              while(rs.next()){
                  if(rs.getString("choice").equals("Deposit")){
                      balance  = balance+ Integer.parseInt( rs.getString("amount"));
                  }
                  else{
                      balance = balance - Integer.parseInt(rs.getString("amount"));
                  }
              }
          }
          catch (Exception ae){
              System.out.println(ae);
          }


          JLabel text = new JLabel("Your current Account Balance is Rs : "+balance);
          text.setForeground(Color.WHITE);
          text.setBounds(170,300,400,30);
          image.add(text);




         setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);

     }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {




           setVisible(false);
           new Transactions(pinnumber).setVisible(true);

    }
}
