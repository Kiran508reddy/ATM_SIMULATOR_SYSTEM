package BANK_MANAGEMENT_SYSTEM;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdrawal extends JFrame implements ActionListener{

    JButton withdraw;

    JButton back;

    JTextField cash;

    String pinnumber;
    Withdrawal(String pinnumber){

        setLayout(null);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        cash = new JFormattedTextField();
        cash.setFont(new Font("Raleway",Font.BOLD,22));
        cash.setBounds(170,350,320,25);
        image.add(cash);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        image.add(withdraw);
        withdraw.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Withdrawal("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        if(e.getSource() == withdraw){
//            String amount = cash.getText();
//            Date date = new Date();
//            if(amount.equals("")){
//                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
//            }
//            else{
//                try {
//                    DatabaseConnection conn = new DatabaseConnection();
//                    String query = "insert into bank values('"+pinnumber+"','"+date+"', 'Withdrawal', '"+amount+"')";
//
//                    conn.s.executeUpdate(query);
//
//                    JOptionPane.showMessageDialog(null,"Rs "+amount + " Withdraw succesfully");
//                    setVisible(false);
//                    new Transactions(pinnumber).setVisible(true);
//
//                } catch (Exception ae) {
//                    System.out.println(ae);
//                    ae.printStackTrace();
//                }
//
//            }
        try{
            String amount = cash.getText();
            Date date = new Date();
            if(e.getSource()==withdraw){
                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    DatabaseConnection conn = new DatabaseConnection();

                    ResultSet rs = conn.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("choice").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    conn.s.executeUpdate("insert into bank values('"+this.pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }else if(e.getSource()==back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }catch(Exception ae){
            ae.printStackTrace();
            System.out.println("error: "+ae);
        }

    }
//        else if(e.getSource()==back){
//            setVisible(false);
//            new Transactions(pinnumber).setVisible(true);
//        }


}
