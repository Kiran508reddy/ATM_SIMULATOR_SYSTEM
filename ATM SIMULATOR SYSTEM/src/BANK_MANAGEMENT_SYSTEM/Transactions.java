package BANK_MANAGEMENT_SYSTEM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

   JButton deposit;
   JButton withdrawal;
   JButton fastcash;
   JButton minisatement;
   JButton pinchange;
   JButton   balanceEnquiry;
   JButton exit;
 private  String pinnumber;

    Transactions(String pinnumber){
        this.pinnumber = pinnumber;

        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transactions");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        add(text);
        image.add(text);

         deposit  = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        add(deposit);
        image.add(deposit);
        deposit.addActionListener(this);

         withdrawal  = new JButton("Cash WithDrawal");
        withdrawal.setBounds(355,415,150,30);
        add(withdrawal);
        image.add(withdrawal);
        withdrawal.addActionListener(this);

         fastcash  = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        add(fastcash);
        image.add(fastcash);
        fastcash.addActionListener(this);

         minisatement  = new JButton("Mini Statement");
        minisatement.setBounds(355,450,150,30);
        add(minisatement);
        image.add(minisatement);
        minisatement.addActionListener(this);

         pinchange  = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        add(pinchange);
        image.add(pinchange);
        pinchange.addActionListener(this);

         balanceEnquiry  = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,485,150,30);
        add(balanceEnquiry);
        image.add(balanceEnquiry);
        balanceEnquiry.addActionListener(this);

         exit  = new JButton("Exit");
        exit.setBounds(355,515,150,30);
        add(exit);
        image.add(exit);
        exit.addActionListener(this);








        setSize(900,900);
        setLocation(300,0);

       setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == exit){
            System.exit(0);
        } else if (e.getSource() == deposit) {
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
        }
        else if(e.getSource() == withdrawal){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }
        else if(e.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(e.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(e.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(e.getSource() == minisatement){
           // setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }

    }
}
