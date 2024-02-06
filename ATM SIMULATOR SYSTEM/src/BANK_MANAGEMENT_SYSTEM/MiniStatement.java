package BANK_MANAGEMENT_SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class MiniStatement extends JFrame {

    String pinnumber;
     MiniStatement(String pinnumber){
         this.pinnumber  = pinnumber;
         setLayout(null);
         this.pinnumber = pinnumber;

         JLabel mini = new JLabel();

         add(mini);

         JLabel bank = new JLabel("State Bank");
         bank.setBounds(150,20,100,20);
         add(bank);

         JLabel card = new JLabel();
         card.setBounds(20,80,300,20);
         add(card);


         JLabel balance  = new JLabel();
         balance.setBounds(20,400,300,20);
         add(balance);

         try{

             DatabaseConnection conn  = new DatabaseConnection();
             ResultSet rs = conn.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");


             while(rs.next()){
                 card.setText("Card Number : "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+ rs.getString("cardnumber").substring(12));
             }
         }
         catch(Exception ae){
             System.out.println(ae);
         }


         try{
             int bal =0;
             DatabaseConnection con = new DatabaseConnection();
             ResultSet rs = con.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");

             while(rs.next()){
                 mini.setText(mini.getText()+ "<html>" +rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("choice")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");

                 if(rs.getString("choice").equals("Deposit")){
                     bal  = bal+ Integer.parseInt( rs.getString("amount"));
                 }
                 else{
                     bal = bal - Integer.parseInt(rs.getString("amount"));
                 }
             }
             balance.setText("Your current account balance is Rs "+bal);

         }

         catch(Exception ae){
             System.out.println(ae);
             ae.printStackTrace();
         }

         mini.setBounds(20,140,400,200);



         setSize(400,600);
         setLocation(20,20);
         setVisible(true);
         getContentPane().setBackground(Color.WHITE);
     }


    public static void main(String[] args) {
        new MiniStatement("");
    }
}
